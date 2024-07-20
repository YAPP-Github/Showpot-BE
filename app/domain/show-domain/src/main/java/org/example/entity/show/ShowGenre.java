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
@Table(name = "app_show_genre")
public class ShowGenre extends BaseEntity {

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Column(name = "genre_id", nullable = false)
    private UUID genreId;

    @Builder
    private ShowGenre(UUID showId, UUID genreId) {
        this.showId = showId;
        this.genreId = genreId;
    }
}