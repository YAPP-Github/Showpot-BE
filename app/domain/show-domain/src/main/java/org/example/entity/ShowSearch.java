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
@Table(name = "app_show_search")
public class ShowSearch extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String artistName;

    @Column(name = "show_id", nullable = false)
    private UUID showId;

}
