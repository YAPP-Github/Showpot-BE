package org.example.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.artist.param.ArtistNamesWithShowIdDomainParam;
import org.example.dto.artist.request.ArtistGenreDomainRequest;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.request.ArtistWithGenreCreateDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistNameDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.dto.artist.response.ArtistSearchPaginationDomainResponse;
import org.example.entity.artist.Artist;
import org.example.entity.genre.Genre;
import org.example.port.ArtistCreatePort;
import org.example.port.ArtistSearchPort;
import org.example.port.dto.param.ArtistSearchPortParam;
import org.example.port.dto.request.ArtistCreatePortRequest;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.request.ArtistsDetailPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.port.dto.response.ArtistsDetailPortResponse;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.artistgenre.ArtistGenreRepository;
import org.example.repository.genre.GenreRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.example.vo.ArtistFilterType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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
    public void save(ArtistWithGenreCreateDomainRequest request) {
        for (ArtistGenreDomainRequest artistGenre : request.artistGenres()) {
            Artist newArtist = artistGenre.toArtist();
            artistRepository.save(newArtist);

            try {
                Genre genre = genreRepository.findByName(artistGenre.genreName())
                    .orElseThrow(NoSuchElementException::new);

                artistGenreRepository.save(newArtist.toArtistGenre(genre.getId()));
            } catch (NoSuchElementException e) {
                log.warn("해당하는 장르가 존재하지 않습니다.");
            }
        }
    }

    public List<ArtistDetailDomainResponse> findAllWithGenreNames() {
        return artistRepository.findAllWithGenreNames();
    }

    public List<ArtistNameDomainResponse> findAllArtistName() {
        return artistRepository.findAllArtistName();
    }

    public List<ArtistNamesWithShowIdDomainParam> findArtistNamesWithShowId() {
        return showArtistRepository.findArtistNamesWithShowId();
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

        ArtistsDetailPortResponse response = artistSearchPort.findArtistsBySpotifyArtistId(
            ArtistsDetailPortRequest.builder()
                .accessToken(artistSearchPort.getAccessToken())
                .spotifyArtistIds(notExistSpotifyIds)
                .build()
        );

        List<Artist> newArtists = response.artists().stream()
            .map(ArtistSearchPortParam::toArtist)
            .toList();

        artistCreatePort.createArtist(
            "createArtist",
            ArtistCreatePortRequest.from(response.artists(), newArtists)
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
        int requiredLimit = request.limit();
        int offset = request.offset();
        boolean hasNext = false;
        String accessToken = artistSearchPort.getAccessToken();
        List<ArtistSearchPortParam> filteredArtists = new ArrayList<>();

        for (int attempt = 0; attempt < 5 && filteredArtists.size() < requiredLimit; attempt++) {
            ArtistSearchPortResponse response = artistSearchPort.searchArtist(
                ArtistSearchPortRequest.builder()
                    .accessToken(accessToken)
                    .search(request.search())
                    .limit(requiredLimit - filteredArtists.size())
                    .offset(offset)
                    .build()
            );

            filteredArtists.addAll(filterKoreanArtistSearch(response));
            offset += response.artists().size();
            hasNext = response.hasNext();

            if (filteredArtists.size() >= requiredLimit) {
                break;
            }
        }

        Map<String, Artist> artistBySpotifyId = getArtistBySpotifyId(filteredArtists);

        return ArtistSearchPaginationDomainResponse.builder()
            .data(
                filteredArtists.stream()
                    .limit(requiredLimit)
                    .map(it -> it.toDomainResponse(
                        artistBySpotifyId.getOrDefault(
                                it.id(),
                                null
                            )
                        )
                    ).toList()
            )
            .limit(request.limit())
            .offset(offset)
            .hasNext(hasNext)
            .build();
    }

    private List<ArtistSearchPortParam> filterKoreanArtistSearch(
        ArtistSearchPortResponse response
    ) {
        return response.artists().stream()
            .filter(artist -> artist.genres().stream()
                .noneMatch(ArtistFilterType::isKoreanArtist))
            .toList();
    }

    //Key : spotifyId
    private Map<String, Artist> getArtistBySpotifyId(List<ArtistSearchPortParam> filteredArtists) {
        List<String> spotifyIds = filteredArtists.stream().map(ArtistSearchPortParam::id).toList();

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

