package org.example.usecase.show;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowInfoResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.entity.BaseEntity;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.ShowSearch;
import org.example.error.ShowError;
import org.example.exception.BusinessException;
import org.example.repository.show.ShowRepository;
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

    @Transactional
    public void save(Show show, List<UUID> artistIds, List<UUID> genreIds) {
        showRepository.save(show);
        showSearchRepository.save(show.toShowSearch());

        List<ShowArtist> showArtists = show.toShowArtist(artistIds);
        showArtistRepository.saveAll(showArtists);

        List<ShowGenre> showGenres = show.toShowGenre(genreIds);
        showGenreRepository.saveAll(showGenres);
    }

    public List<ShowInfoResponse> findAllShowInfos() {
        return showRepository.findAllShowInfos();
    }

    public ShowInfoResponse findShowInfo(UUID id) {
        return showRepository.findShowInfoById(id)
            .orElseThrow(() -> new BusinessException(ShowError.ENTITY_NOT_FOUND_ERROR));
    }

    @Transactional
    public void updateShow(UUID id, Show newShow, List<UUID> newArtistIds, List<UUID> newGenreIds) {
        Show show = findShowById(id);
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
        Show show = findShowById(id);
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


    private Show findShowById(UUID id) {
        return showRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
