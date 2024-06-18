package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_show_artist")
public class ShowArtist extends BaseEntity {

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Column(name = "artist_id", nullable = false)
    private UUID artistId;
}
