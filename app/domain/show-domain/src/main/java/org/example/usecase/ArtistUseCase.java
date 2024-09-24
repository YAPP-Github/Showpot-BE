package org.example.usecase;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistCreateDomainRequest;
import org.example.dto.artist.request.ArtistGenreDomainRequest;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistNameDomainResponse;
import org.example.dto.artist.response.ArtistNamesWithShowIdDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.dto.artist.response.ArtistSearchPaginationDomainResponse;
import org.example.entity.artist.Artist;
import org.example.entity.genre.Genre;
import org.example.port.ArtistCreatePort;
import org.example.port.ArtistSearchPort;
import org.example.port.dto.param.ArtistSearchPortParam;
import org.example.port.dto.request.ArtistCreatePortRequest;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.request.FindArtistsPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.artistgenre.ArtistGenreRepository;
import org.example.repository.genre.GenreRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.example.util.ReflectionUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistUseCase {

    private final ArtistRepository artistRepository;
    private final ArtistGenreRepository artistGenreRepository;
    private final ShowArtistRepository showArtistRepository;
    private final GenreRepository genreRepository;
    private final ArtistSearchPort artistSearchPort;
    private final ArtistCreatePort artistCreatePort;


    @Transactional
    public void save(ArtistCreateDomainRequest request) {
        for (ArtistGenreDomainRequest artistGenre : request.artistGenres()) {
            Artist newArtist = artistGenre.toArtist();
            ReflectionUtil.setSuperClassId(newArtist, artistGenre.artistId());
            artistRepository.save(newArtist);

            Genre genre = genreRepository.findByName(artistGenre.genreName())
                .orElseThrow(NoSuchElementException::new);

            artistGenreRepository.save(newArtist.toArtistGenre(genre.getId()));
        }
    }

    public List<ArtistDetailDomainResponse> findAllWithGenreNames() {
        return artistRepository.findAllWithGenreNames();
    }

    public List<ArtistNameDomainResponse> findAllArtistKoreanName() {
        return artistRepository.findAllArtistKoreanName();
    }

    public List<ArtistNamesWithShowIdDomainResponse> findArtistKoreanNamesWithShowId() {
        return showArtistRepository.findArtistKoreanNamesWithShowId();
    }

    public List<Artist> findOrCreateArtistBySpotifyId(List<String> spotifyIds) {
        List<Artist> existArtists = artistRepository.findArtistsBySpotifyIdIn(spotifyIds);

        List<String> existSpotifyIds = existArtists.stream()
            .map(Artist::getSpotifyId)
            .toList();

        List<String> notExistSpotifyIds = spotifyIds.stream()
            .filter(id -> !existSpotifyIds.contains(id))
            .toList();

        if (notExistSpotifyIds.isEmpty()) {
            return existArtists;
        }

        List<ArtistSearchPortParam> response = artistSearchPort.findArtistsBySpotifyArtistId(
            FindArtistsPortRequest.builder()
                .accessToken(artistSearchPort.getAccessToken())
                .spotifyArtistIds(notExistSpotifyIds)
                .build()
        );

        List<Artist> newArtists = response.stream()
            .map(ArtistSearchPortParam::toArtist)
            .toList();

        artistCreatePort.createArtist(
            "createArtist",
            ArtistCreatePortRequest.from(response, newArtists)
        );

        return Stream.concat(existArtists.stream(), newArtists.stream()).toList();
    }

    public ArtistPaginationDomainResponse findAllArtistInCursorPagination(
        ArtistPaginationDomainRequest request
    ) {
        return artistRepository.findAllWithCursorPagination(request);
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

        Map<String, Artist> artistBySpotifyId = getArtistBySpotifyId(
            response.getSpotifyArtistIds()
        );

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

