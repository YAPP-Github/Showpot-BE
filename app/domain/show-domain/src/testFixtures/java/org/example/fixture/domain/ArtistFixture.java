package org.example.fixture.domain;

import java.util.List;
import java.util.stream.IntStream;
import org.example.entity.artist.Artist;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

public class ArtistFixture {

    public static Artist womanGroup() {
        return Artist.builder()
            .koreanName("아이브")
            .englishName("IVE")
            .image("abc")
            .country("KOREA")
            .artistGender(ArtistGender.WOMAN)
            .artistType(ArtistType.GROUP)
            .build();
    }

    public static List<Artist> manSoloArtists(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> Artist.builder()
                .koreanName("testKoreanName" + i)
                .englishName("testEnglishName" + i)
                .image("testImage" + i)
                .country("testCountry" + i)
                .artistGender(ArtistGender.MAN)
                .artistType(ArtistType.SOLO)
                .build()
            )
            .toList();
    }
}
