package org.example.repository.show.showartist;

import java.util.List;
import org.example.dto.artist.response.ArtistKoreanNamesWithShowIdDomainResponse;

public interface ShowArtistQuerydslRepository {

    List<ArtistKoreanNamesWithShowIdDomainResponse> findArtistKoreanNamesWithShowId();
}
