package org.example.entity.show;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;
import org.example.entity.show.info.SeatPrice;
import org.example.util.StringNormalizer;
import org.hibernate.annotations.Type;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "show")
public class Show extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "image", nullable = false)
    private String image;

    @Enumerated
    private SeatPrice seatPrice;

    @Type(JsonType.class)
    @Column(name = "ticketing", columnDefinition = "jsonb", nullable = false)
    private Map<String, String> ticketingSiteInfo = new HashMap<>();

    @Builder
    private Show(
        String title,
        String content,
        LocalDate startDate,
        LocalDate endDate,
        String location,
        String image,
        SeatPrice seatPrice,
        Map<String, String> ticketingSiteInfo
    ) {
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.image = image;
        this.seatPrice = seatPrice;
        this.ticketingSiteInfo = ticketingSiteInfo;
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

    public ShowSearch toShowSearch() {
        return ShowSearch.builder()
            .name(StringNormalizer.removeWhitespaceAndLowerCase(title))
            .show(this)
            .build();
    }

    public void changeShowInfo(Show newShow) {
        this.title = newShow.title;
        this.content = newShow.content;
        this.startDate = newShow.startDate;
        this.location = newShow.location;
        this.image = newShow.image;
        this.seatPrice = newShow.seatPrice;
    }

    public void saveTicketingInformation(
        String ticketBookingSite,
        String ticketingSiteUrl
    ) {
        ticketingSiteInfo.put(ticketBookingSite, ticketingSiteUrl);
    }

    public Map<String, String> getTicketingInformation() {
        return new HashMap<>(ticketingSiteInfo);
    }
}