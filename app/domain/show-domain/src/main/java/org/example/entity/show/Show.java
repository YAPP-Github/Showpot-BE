package org.example.entity.show;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
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

    @Enumerated
    private SeatPrice seatPrice;

    @Enumerated
    private Ticketing ticketing;

    @OneToMany(mappedBy = "app_show", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowImage> images = new ArrayList<>();

}