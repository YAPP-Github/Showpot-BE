package org.example.repository.show.showartist;

import java.util.List;
import org.example.dto.artist.response.ArtistNamesWithShowIdDomainResponse;

public interface ShowArtistQuerydslRepository {

    List<ArtistNamesWithShowIdDomainResponse> findArtistKoreanNamesWithShowId();
}
