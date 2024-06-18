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
@Table(name = "app_show_genre")
public class ShowGenre extends BaseEntity {

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Column(name = "genre_id", nullable = false)
    private UUID genreId;

}