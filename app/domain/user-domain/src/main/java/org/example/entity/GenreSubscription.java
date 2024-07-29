package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "genre_subscription")
public class GenreSubscription extends BaseEntity {

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID genreId;

    @Builder
    private GenreSubscription(UUID userId, UUID genreId) {
        this.userId = userId;
        this.genreId = genreId;
    }

    public void subscribe() {
        this.revive();
    }

    public void unsubscribe() {
        this.softDelete();
    }
}
