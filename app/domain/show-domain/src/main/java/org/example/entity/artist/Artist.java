package org.example.entity.artist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_artist")
public class Artist extends BaseEntity {

    @Column(name = "korean_name", nullable = false)
    private String koreanName;

    @Column(name = "english_name", nullable = false)
    private String englishName;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "gender", nullable = false)
    private ArtistGender artistGender;

    @Column(name = "type", nullable = false)
    private ArtistType artistType;

}
