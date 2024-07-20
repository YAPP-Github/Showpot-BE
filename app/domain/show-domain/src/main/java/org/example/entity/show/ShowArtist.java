package org.example.entity.show;

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
@Table(name = "show_artist")
public class ShowArtist extends BaseEntity {

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Column(name = "artist_id", nullable = false)
    private UUID artistId;

    @Builder
    private ShowArtist(UUID showId, UUID artistId) {
        this.showId = showId;
        this.artistId = artistId;
    }
}
