package org.example.entity.artist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "artist")
public class Artist extends BaseEntity {

    @Column(name = "korean_name", nullable = false)
    private String koreanName;

    @Column(name = "english_name", nullable = false)
    private String englishName;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ArtistGender artistGender;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ArtistType artistType;

    @Builder
    private Artist(
        String koreanName,
        String englishName,
        String image,
        String country,
        ArtistGender artistGender,
        ArtistType artistType
    ) {
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.image = image;
        this.country = country;
        this.artistGender = artistGender;
        this.artistType = artistType;
    }

    public List<ArtistGenre> toArtistGenre(List<UUID> genreIds) {
        return genreIds.stream()
            .map(genreId -> ArtistGenre.builder()
                .artistId(getId())
                .genreId(genreId)
                .build())
            .toList();
    }

    public void changeArtistInfo(Artist newArtist) {
        this.koreanName = newArtist.koreanName;
        this.englishName = newArtist.englishName;
        this.image = newArtist.image;
        this.country = newArtist.country;
        this.artistGender = newArtist.artistGender;
        this.artistType = newArtist.artistType;
    }
}
