package org.example.repository.artist;

import java.util.List;
import org.example.dto.artist.response.ArtistDetailResponse;

public interface ArtistQuerydslRepository {

    List<ArtistDetailResponse> findAllWithGenreNames();

}
