package org.example.entity.artist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "artist")
public class Artist extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "spotify_id", unique = true, nullable = false)
    private String spotifyId;

    @Builder
    private Artist(
        String name,
        String image,
        String spotifyId
    ) {
        this.name = name;
        this.image = image;
        this.spotifyId = spotifyId;
    }

    public Artist changeId(UUID id) {
        this.setId(id);
        return this;
    }

    public ArtistGenre toArtistGenre(UUID genreId) {
        return ArtistGenre.builder()
            .artistId(getId())
            .genreId(genreId)
            .build();
    }
}
