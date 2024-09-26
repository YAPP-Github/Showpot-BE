package org.example.repository.show.showartist;

import java.util.List;
import org.example.dto.artist.param.ArtistNamesWithShowIdDomainParam;

public interface ShowArtistQuerydslRepository {

    List<ArtistNamesWithShowIdDomainParam> findArtistKoreanNamesWithShowId();
}
