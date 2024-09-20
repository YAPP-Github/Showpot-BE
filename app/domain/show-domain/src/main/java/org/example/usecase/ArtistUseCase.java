package org.example.usecase;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistFilterTotalCountDomainRequest;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNamesWithShowIdDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.dto.artist.response.ArtistSearchPaginationDomainResponse;
import org.example.entity.BaseEntity;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.entity.show.ShowArtist;
import org.example.port.ArtistSearchPort;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.artistgenre.ArtistGenreRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistUseCase {

    private final ArtistRepository artistRepository;
    private final ArtistGenreRepository artistGenreRepository;
    private final ShowArtistRepository showArtistRepository;
    private final ArtistSearchPort artistSearchPort;

    @Transactional
    public void save(Artist artist, List<UUID> genreIds) {
        artistRepository.save(artist);

        List<ArtistGenre> artistGenres = artist.toArtistGenre(genreIds);
        artistGenreRepository.saveAll(artistGenres);
    }

    public List<ArtistDetailDomainResponse> findAllWithGenreNames() {
        return artistRepository.findAllWithGenreNames();
    }

    public List<ArtistKoreanNameDomainResponse> findAllArtistKoreanName() {
        return artistRepository.findAllArtistKoreanName();
    }

    public ArtistDetailDomainResponse findArtistDetailById(UUID id) {
        return artistRepository.findArtistWithGenreNamesById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public List<ArtistKoreanNamesWithShowIdDomainResponse> findArtistKoreanNamesWithShowId() {
        return showArtistRepository.findArtistKoreanNamesWithShowId();
    }

    public List<Artist> findAllArtistInIds(List<UUID> ids) {
        return artistRepository.findAllInIds(ids);
    }

    public ArtistPaginationDomainResponse findAllArtistInCursorPagination(
        ArtistPaginationDomainRequest request
    ) {
        return artistRepository.findAllWithCursorPagination(request);
    }

    public ArtistFilterTotalCountDomainResponse findFilterArtistTotalCount(
        ArtistFilterTotalCountDomainRequest request
    ) {
        return artistRepository.findFilterArtistTotalCount(request)
            .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void updateArtist(UUID id, Artist newArtist, List<UUID> newGenreIds) {
        Artist artist = findArtistById(id);
        artist.changeArtistInfo(newArtist);

        updateArtistGenre(newGenreIds, artist);
    }

    private void updateArtistGenre(List<UUID> newGenreIds, Artist artist) {
        List<ArtistGenre> currentGenres = artistGenreRepository.findAllByArtistIdAndIsDeletedFalse(
            artist.getId());

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

        List<ArtistGenre> artistGenres = artistGenreRepository.findAllByArtistIdAndIsDeletedFalse(
            artist.getId());
        artistGenres.forEach(BaseEntity::softDelete);

        List<ShowArtist> showArtists = showArtistRepository.findAllByArtistIdAndIsDeletedFalse(
            artist.getId());
        showArtists.forEach(BaseEntity::softDelete);
    }

    public ArtistSearchPaginationDomainResponse searchArtist(
        ArtistSearchPaginationDomainRequest request
    ) {
        ArtistSearchPortResponse response = artistSearchPort.searchArtist(
            ArtistSearchPortRequest.builder()
                .accessToken(artistSearchPort.getAccessToken())
                .search(request.search())
                .limit(request.limit())
                .offset(request.offset())
                .build()
        );

        Map<String, Artist> artistBySpotifyId = getArtistBySpotifyId(response.getSpotifyArtistIds());

        return ArtistSearchPaginationDomainResponse.builder()
            .data(
                response.artists().stream()
                    .map(it -> it.toDomainResponse(
                            artistBySpotifyId.getOrDefault(
                                it.id(),
                                null
                            )
                        )
                    ).toList()
            )
            .limit(response.limit())
            .offset(response.offset())
            .hasNext(response.hasNext())
            .build();
    }

    private Artist findArtistById(UUID id) {
        return artistRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    private Map<String, Artist> getArtistBySpotifyId(List<String> spotifyIds) {
        return artistRepository.findArtistsBySpotifyIdIn(spotifyIds)
            .stream()
            .collect(
                Collectors.toMap(
                    Artist::getSpotifyId,
                    Function.identity()
                )
            );
    }
}

