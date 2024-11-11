package org.example.usecase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.param.ShowWithTicketingTimesDomainParam;
import org.example.dto.show.request.ShowCreationDomainRequest;
import org.example.dto.show.request.ShowUpdateDomainRequest;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.entity.BaseEntity;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.ShowSearch;
import org.example.entity.show.info.ShowTicketingTimes;
import org.example.repository.show.ShowRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.example.repository.show.showgenre.ShowGenreRepository;
import org.example.repository.show.showsearch.ShowSearchRepository;
import org.example.repository.show.showticketing.ShowTicketingTimeRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ShowAdminUseCase {

    private final ShowRepository showRepository;
    private final ShowSearchRepository showSearchRepository;
    private final ShowArtistRepository showArtistRepository;
    private final ShowGenreRepository showGenreRepository;
    private final ShowTicketingTimeRepository showTicketingTimeRepository;

    @Transactional
    public Show save(
        ShowCreationDomainRequest request
    ) {
        Show show = request.toShow();
        showRepository.save(show);
        showSearchRepository.save(show.toShowSearch());

        var showArtists = show.toShowArtist(request.artistIds());
        showArtistRepository.saveAll(showArtists);

        var showGenres = show.toShowGenre(request.genreIds());
        showGenreRepository.saveAll(showGenres);

        var showTicketingTimes = show.toShowTicketingTime(request.showTicketingTimes());
        showTicketingTimeRepository.saveAll(showTicketingTimes);

        return show;
    }

    public List<ShowWithTicketingTimesDomainParam> findShowDetailWithTicketingTimes() {
        return showRepository.findShowDetailWithTicketingTimes();
    }

    public ShowInfoDomainResponse findShowInfo(UUID id) {
        return showRepository.findShowInfoById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void updateShow(UUID id, ShowUpdateDomainRequest request) {
        Show show = findShowOrThrowNoSuchElementException(id);
        Show updateShow = request.toShow();

        show.changeShowInfo(updateShow);
        updateShowSearch(show);
        updateShowArtist(request.artistIds(), show);
        updateShowGenre(request.genreIds(), show);
        updateShowTicketingTimes(request.showTicketingTimes(), show);
    }

    public void updateShowSearch(Show show) {
        var newShowSearch = show.toShowSearch();
        var currentShowSearches = findShowSearchesByShowId(show.getId());
        var showNames = currentShowSearches.stream().map(ShowSearch::getName).toList();

        if (!showNames.contains(newShowSearch.getName())) {
            showSearchRepository.save(newShowSearch);

            var showSearchesToRemove = currentShowSearches.stream()
                .filter(showSearch -> !newShowSearch.getName().equals(showSearch.getName()))
                .toList();
            showSearchesToRemove.forEach(BaseEntity::softDelete);
        }
    }

    public void updateShowArtist(List<UUID> newArtistIds, Show show) {
        var currentShowArtists = findShowArtistsByShowId(show.getId());
        var artistIdsToAdd = getArtistIdsToAdd(newArtistIds, currentShowArtists);
        showArtistRepository.saveAll(show.toShowArtist(artistIdsToAdd));

        var showArtistsToRemove = currentShowArtists.stream()
            .filter(showArtist -> !newArtistIds.contains(showArtist.getArtistId()))
            .toList();
        showArtistsToRemove.forEach(BaseEntity::softDelete);
    }

    public List<UUID> getArtistIdsToAdd(
        List<UUID> newArtistIds,
        List<ShowArtist> currentShowArtists
    ) {
        var currentArtistIds = currentShowArtists.stream()
            .map(ShowArtist::getArtistId)
            .toList();

        return newArtistIds.stream()
            .filter(newArtistId -> !currentArtistIds.contains(newArtistId))
            .toList();
    }

    public void updateShowGenre(List<UUID> newGenreIds, Show show) {
        List<ShowGenre> currentShowGenres = findShowGenresByShowId(show.getId());
        List<UUID> genreIdsToAdd = getGenreIdsToAdd(newGenreIds, currentShowGenres);
        showGenreRepository.saveAll(show.toShowGenre(genreIdsToAdd));

        List<ShowGenre> showGenresToRemove = currentShowGenres.stream()
            .filter(showGenre -> !newGenreIds.contains(showGenre.getGenreId()))
            .toList();
        showGenresToRemove.forEach(BaseEntity::softDelete);
    }

    public List<UUID> getGenreIdsToAdd(
        List<UUID> newGenreIds,
        List<ShowGenre> currentShowGenres
    ) {
        var currentGenreIds = currentShowGenres.stream()
            .map(ShowGenre::getGenreId)
            .toList();

        return newGenreIds.stream()
            .filter(newGenreId -> !currentGenreIds.contains(newGenreId))
            .toList();
    }

    public void updateShowTicketingTimes(ShowTicketingTimes ticketingTimes, Show show) {
        var currentShowTicketingTimes = showTicketingTimeRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId()
        );

        var newShowTicketingTimes = show.toShowTicketingTime(ticketingTimes);
        var ticketingTimesToAdd = newShowTicketingTimes.stream()
            .filter(
                newTicketingTime ->
                    !currentShowTicketingTimes.contains(newTicketingTime)
            )
            .toList();
        showTicketingTimeRepository.saveAll(ticketingTimesToAdd);

        var showGenresToRemove = currentShowTicketingTimes.stream()
            .filter(curTicketingTime -> !newShowTicketingTimes.contains(curTicketingTime))
            .toList();
        showGenresToRemove.forEach(BaseEntity::softDelete);
    }

    @Transactional
    public void deleteShow(UUID id) {
        Show show = findShowOrThrowNoSuchElementException(id);
        show.softDelete();

        var showArtists = showArtistRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        showArtists.forEach(BaseEntity::softDelete);

        var showGenres = showGenreRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        showGenres.forEach(BaseEntity::softDelete);

        var showSearches = showSearchRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        showSearches.forEach(BaseEntity::softDelete);

        var showTicketingTimes = showTicketingTimeRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId()
        );
        showTicketingTimes.forEach(BaseEntity::softDelete);
    }


    public List<ShowArtist> findShowArtistsByShowId(UUID showId) {
        return showArtistRepository.findAllByShowIdAndIsDeletedFalse(showId);
    }

    public List<ShowGenre> findShowGenresByShowId(UUID showId) {
        return showGenreRepository.findAllByShowIdAndIsDeletedFalse(showId);
    }

    public List<ShowSearch> findShowSearchesByShowId(UUID showId) {
        return showSearchRepository.findAllByShowIdAndIsDeletedFalse(showId);
    }

    private Show findShowOrThrowNoSuchElementException(UUID id) {
        return showRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
