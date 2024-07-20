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
@Table(name = "artist_subscription")
public class ArtistSubscription extends BaseEntity {

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID artistId;

}
