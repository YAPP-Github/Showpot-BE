package org.example.entity.show;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_show")
public class Show extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "image", nullable = false)
    private String image;

    @Enumerated
    private SeatPrice seatPrice;

    @Enumerated
    private Ticketing ticketing;

    @Builder
    private Show(String title, String content, LocalDate date, String location, String image,
        SeatPrice seatPrice, Ticketing ticketing) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.location = location;
        this.image = image;
        this.seatPrice = seatPrice;
        this.ticketing = ticketing;
    }

    public List<ShowArtist> toShowArtist(List<UUID> artistIds) {
        return artistIds.stream()
            .map(artistId -> ShowArtist.builder()
                .showId(getId())
                .artistId(artistId)
                .build())
            .toList();
    }

    public List<ShowGenre> toShowGenre(List<UUID> genreIds) {
        return genreIds.stream()
            .map(genreId -> ShowGenre.builder()
                .showId(getId())
                .genreId(genreId)
                .build())
            .toList();
    }
}