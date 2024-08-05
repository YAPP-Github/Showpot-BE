package org.example.usecase.show;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowCreationDomainRequest;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.request.ShowUpdateDomainRequest;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.entity.BaseEntity;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.info.ShowTicketingTimes;
import org.example.repository.show.ShowRepository;
import org.example.repository.show.ShowTicketingTimeRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.example.repository.show.showgenre.ShowGenreRepository;
import org.example.repository.show.showsearch.ShowSearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ShowUseCase {

    private final ShowRepository showRepository;
    private final ShowSearchRepository showSearchRepository;
    private final ShowArtistRepository showArtistRepository;
    private final ShowGenreRepository showGenreRepository;
    private final ShowTicketingTimeRepository showTicketingTimeRepository;

    @Transactional
    public void save(
        ShowCreationDomainRequest request
    ) {
        Show show = request.toShow();
        showRepository.save(show);
        showSearchRepository.save(show.toShowSearch());

        var showArtists = show.toShowArtist(request.artistIds());
        showArtistRepository.saveAll(showArtists);

        var showGenres = show.toShowGenre(request.genreIds());
        showGenreRepository.saveAll(showGenres);

        var showTicketingTimes = show.toShowTicketingTime(
            request.showTicketingTimes());
        showTicketingTimeRepository.saveAll(showTicketingTimes);
    }

    public List<ShowInfoDomainResponse> findAllShowInfos() {
        return showRepository.findAllShowInfos();
    }

    public ShowDetailDomainResponse findShowDetail(UUID id) {
        return showRepository.findShowDetailById(id).orElseThrow(NoSuchElementException::new);
    }

    public ShowInfoDomainResponse findShowInfo(UUID id) {
        return showRepository.findShowInfoById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void updateShow(UUID id, ShowUpdateDomainRequest request) {
        Show show = findShowById(id);
        show.changeShowInfo(request.toShow());

        updateShowArtist(request.artistIds(), show);
        updateShowGenre(request.genreIds(), show);
        updateShowTicketingTimes(request.showTicketingTimes(), show);
    }

    private void updateShowArtist(List<UUID> newArtistIds, Show show) {
        var currentShowArtists = showArtistRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        var currentArtistIds = currentShowArtists.stream()
            .map(ShowArtist::getArtistId)
            .toList();

        var artistIdsToAdd = newArtistIds.stream()
            .filter(newArtistId -> !currentArtistIds.contains(newArtistId))
            .toList();
        var showArtistsToAdd = show.toShowArtist(artistIdsToAdd);
        showArtistRepository.saveAll(showArtistsToAdd);

        var showArtistsToRemove = currentShowArtists.stream()
            .filter(showArtist -> !newArtistIds.contains(showArtist.getArtistId()))
            .toList();
        showArtistsToRemove.forEach(BaseEntity::softDelete);
    }

    private void updateShowGenre(List<UUID> newGenreIds, Show show) {
        var currentShowGenres = showGenreRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        var currentGenreIds = currentShowGenres.stream()
            .map(ShowGenre::getGenreId)
            .toList();

        var genreIdsToAdd = newGenreIds.stream()
            .filter(newGenreId -> !currentGenreIds.contains(newGenreId))
            .toList();
        var showGenresToAdd = show.toShowGenre(genreIdsToAdd);
        showGenreRepository.saveAll(showGenresToAdd);

        var showGenresToRemove = currentShowGenres.stream()
            .filter(showGenre -> !newGenreIds.contains(showGenre.getGenreId()))
            .toList();
        showGenresToRemove.forEach(BaseEntity::softDelete);
    }

    private void updateShowTicketingTimes(ShowTicketingTimes ticketingTimes, Show show) {
        var currentShowTicketingTimes = showTicketingTimeRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId()
        );
        var currentShowTicketingTimeIds = currentShowTicketingTimes.stream()
            .map(BaseEntity::getId)
            .toList();

        var newShowTicketingTimes = show.toShowTicketingTime(ticketingTimes);
        var newShowTicketingTimeIds = newShowTicketingTimes.stream()
            .map(BaseEntity::getId)
            .toList();

        var ticketingTimesToAdd = newShowTicketingTimes.stream()
            .filter(
                newTicketingTime -> !currentShowTicketingTimeIds.contains(newTicketingTime.getId()))
            .toList();
        showTicketingTimeRepository.saveAll(ticketingTimesToAdd);

        var showGenresToRemove = currentShowTicketingTimes.stream()
            .filter(ticketingTime -> !newShowTicketingTimeIds.contains(ticketingTime.getId()))
            .toList();
        showGenresToRemove.forEach(BaseEntity::softDelete);
    }

    @Transactional
    public void deleteShow(UUID id) {
        Show show = findShowById(id);
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

    public ShowSearchPaginationDomainResponse searchShow(
        ShowSearchPaginationDomainRequest request) {
        return showSearchRepository.searchShow(request);
    }


    private Show findShowById(UUID id) {
        return showRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
