package org.example.dto.artist.response;

import java.util.UUID;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

/**
 * 엔티티 조회 객체
 */
public record ArtistDomainResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image,
    String country,
    ArtistGender artistGender,
    ArtistType artistType
) {

}
