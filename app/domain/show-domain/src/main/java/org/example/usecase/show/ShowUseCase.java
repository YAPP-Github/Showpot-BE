package org.example.usecase.show;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowCreationDomainRequest;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.entity.BaseEntity;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.ShowSearch;
import org.example.entity.show.ShowTicketingTime;
import org.example.error.ShowError;
import org.example.exception.BusinessException;
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
        showRepository.save(request.toShow());
        showSearchRepository.save(request.toShowSearch(show));

        List<ShowArtist> showArtists = request.toShowArtist(show);
        showArtistRepository.saveAll(showArtists);

        List<ShowGenre> showGenres = request.toShowGenre(show);
        showGenreRepository.saveAll(showGenres);

        List<ShowTicketingTime> showTicketingTimes = request.toShowTicketing(show);
        showTicketingTimeRepository.saveAll(showTicketingTimes);
    }

    public List<ShowInfoDomainResponse> findAllShowInfos() {
        return showRepository.findAllShowInfos();
    }

    public ShowDetailDomainResponse findShowDetail(UUID id) {
        return showRepository.findShowDetailById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public ShowInfoDomainResponse findShowInfo(UUID id) {
        return showRepository.findShowInfoById(id)
            .orElseThrow(() -> new BusinessException(ShowError.ENTITY_NOT_FOUND_ERROR));
    }

    @Transactional
    public void updateShow(UUID id, Show newShow, List<UUID> newArtistIds, List<UUID> newGenreIds) {
        Show show = findShowOrThrowNoSuchElementException(id);
        show.changeShowInfo(newShow);

        updateShowArtist(newArtistIds, show);
        updateShowGenre(newGenreIds, show);
    }

    private void updateShowArtist(List<UUID> newArtistIds, Show show) {
        List<ShowArtist> currentShowArtists = showArtistRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        List<UUID> currentArtistIds = currentShowArtists.stream()
            .map(ShowArtist::getArtistId)
            .toList();

        List<UUID> artistIdsToAdd = newArtistIds.stream()
            .filter(newArtistId -> !currentArtistIds.contains(newArtistId))
            .toList();
        List<ShowArtist> showArtistsToAdd = show.toShowArtist(artistIdsToAdd);
        showArtistRepository.saveAll(showArtistsToAdd);

        List<ShowArtist> showArtistsToRemove = currentShowArtists.stream()
            .filter(showArtist -> !newArtistIds.contains(showArtist.getArtistId()))
            .toList();
        showArtistsToRemove.forEach(BaseEntity::softDelete);
    }

    private void updateShowGenre(List<UUID> newGenreIds, Show show) {
        List<ShowGenre> currentShowGenres = showGenreRepository.findAllByShowIdAndIsDeletedFalse(
            show.getId());
        List<UUID> currentGenreIds = currentShowGenres.stream()
            .map(ShowGenre::getGenreId)
            .toList();

        List<UUID> genreIdsToAdd = newGenreIds.stream()
            .filter(newGenreId -> !currentGenreIds.contains(newGenreId))
            .toList();
        List<ShowGenre> showGenresToAdd = show.toShowGenre(genreIdsToAdd);
        showGenreRepository.saveAll(showGenresToAdd);

        List<ShowGenre> showGenresToRemove = currentShowGenres.stream()
            .filter(showGenre -> !newGenreIds.contains(showGenre.getGenreId()))
            .toList();
        showGenresToRemove.forEach(BaseEntity::softDelete);
    }

    @Transactional
    public void deleteShow(UUID id) {
        Show show = findShowOrThrowNoSuchElementException(id);
        show.softDelete();

        List<ShowArtist> showArtists = showArtistRepository.findAllByShowIdAndIsDeletedFalse(show.getId());
        showArtists.forEach(BaseEntity::softDelete);

        List<ShowGenre> showGenres = showGenreRepository.findAllByShowIdAndIsDeletedFalse(show.getId());
        showGenres.forEach(BaseEntity::softDelete);

        List<ShowSearch> showSearches = showSearchRepository.findAllByShowIdAndIsDeletedFalse(show.getId());
        showSearches.forEach(BaseEntity::softDelete);
    }

    public ShowSearchPaginationDomainResponse searchShow(
        ShowSearchPaginationDomainRequest request) {
        return showSearchRepository.searchShow(request);
    }


    private Show findShowOrThrowNoSuchElementException(UUID id) {
        return showRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
