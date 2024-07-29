package org.example.usecase.artist;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailPaginationResponse;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.entity.BaseEntity;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.entity.artist.ArtistSearch;
import org.example.entity.show.ShowArtist;
import org.example.error.ArtistError;
import org.example.exception.BusinessException;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.artistgenre.ArtistGenreRepository;
import org.example.repository.artist.artistsearch.ArtistSearchRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistUseCase {

    private final ArtistRepository artistRepository;
    private final ArtistSearchRepository artistSearchRepository;
    private final ArtistGenreRepository artistGenreRepository;
    private final ShowArtistRepository showArtistRepository;

    @Transactional
    public void save(Artist artist, List<UUID> genreIds) {
        artistRepository.save(artist);

        List<ArtistSearch> artistSearches = artist.toArtistSearch();
        artistSearchRepository.saveAll(artistSearches);

        List<ArtistGenre> artistGenres = artist.toArtistGenre(genreIds);
        artistGenreRepository.saveAll(artistGenres);
    }

    public List<ArtistDetailResponse> findAllWithGenreNames() {
        return artistRepository.findAllWithGenreNames();
    }

    public List<ArtistKoreanNameResponse> findAllArtistKoreanName() {
        return artistRepository.findAllArtistKoreanName();
    }

    public ArtistDetailResponse findArtistDetailById(UUID id) {
        return artistRepository.findArtistWithGenreNamesById(id)
            .orElseThrow(() -> new BusinessException(ArtistError.ENTITY_NOT_FOUND_ERROR));
    }

    public List<Artist> findAllArtistInIds(List<UUID> ids) {
        return artistRepository.findAllInIds(ids);
    }

    public ArtistDetailPaginationResponse findAllArtistInCursorPagination(
        ArtistPaginationDomainRequest request) {
        return artistRepository.findAllWithCursorPagination(request);
    }

    @Transactional
    public void updateArtist(UUID id, Artist newArtist, List<UUID> newGenreIds) {
        Artist artist = findArtistById(id);
        artist.changeArtistInfo(newArtist);

        List<ArtistGenre> currentGenres = artistGenreRepository.findAllByArtistIdAndIsDeletedFalse(artist.getId());

        List<UUID> currentGenreIds = currentGenres.stream()
            .map(ArtistGenre::getGenreId)
            .toList();

        List<UUID> genreIdsToAdd = newGenreIds.stream()
            .filter(newGenreId -> !currentGenreIds.contains(newGenreId))
            .toList();
        List<ArtistGenre> artistGenresToAdd = artist.toArtistGenre(genreIdsToAdd);
        artistGenreRepository.saveAll(artistGenresToAdd);

        List<ArtistGenre> artistGenresToRemove = currentGenres.stream()
            .filter(ag -> !newGenreIds.contains(ag.getGenreId()))
            .toList();
        artistGenresToRemove.forEach(BaseEntity::softDelete);
    }

    @Transactional
    public void deleteArtist(UUID id) {
        Artist artist = findArtistById(id);
        artist.softDelete();

        List<ArtistGenre> artistGenres = artistGenreRepository.findAllByArtistIdAndIsDeletedFalse(artist.getId());
        artistGenres.forEach(BaseEntity::softDelete);

        List<ShowArtist> showArtists = showArtistRepository.findAllByArtistIdAndIsDeletedFalse(artist.getId());
        showArtists.forEach(BaseEntity::softDelete);

        List<ArtistSearch> artistSearches = artistSearchRepository.findAllByArtistIdAndIsDeletedFalse(artist.getId());
        artistSearches.forEach(BaseEntity::softDelete);
    }

    public ArtistDetailPaginationResponse searchArtist(
        ArtistSearchPaginationDomainRequest request) {
        return artistSearchRepository.searchArtist(request);
    }

    private Artist findArtistById(UUID id) {
        return artistRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }
}

