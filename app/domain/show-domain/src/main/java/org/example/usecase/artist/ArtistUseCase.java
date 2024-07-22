package org.example.usecase.artist;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.entity.BaseEntity;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.entity.artist.ArtistSearch;
import org.example.entity.show.ShowArtist;
import org.example.error.ArtistError;
import org.example.exception.BusinessException;
import org.example.repository.artist.ArtistGenreRepository;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.ArtistSearchRepository;
import org.example.repository.show.ShowArtistRepository;
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

    @Transactional
    public void updateArtist(UUID id, Artist newArtist, List<UUID> newGenreIds) {
        Artist artist = findArtistById(id);
        artist.changeArtistInfo(newArtist);

        List<ArtistGenre> currentGenres = artistGenreRepository.findAllByArtistId(artist.getId());

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

        List<ArtistGenre> artistGenres = artistGenreRepository.findAllByArtistId(artist.getId());
        artistGenres.forEach(BaseEntity::softDelete);

        List<ShowArtist> showArtists = showArtistRepository.findAllByArtistId(artist.getId());
        showArtists.forEach(BaseEntity::softDelete);
    }

    private Artist findArtistById(UUID id) {
        return artistRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ArtistError.ENTITY_NOT_FOUND_ERROR));
    }

}

