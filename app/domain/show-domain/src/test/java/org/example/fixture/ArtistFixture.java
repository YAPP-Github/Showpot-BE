package org.example.fixture;

import org.example.entity.artist.Artist;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

public class ArtistFixture {

    public static Artist test() {
        return Artist.builder()
            .koreanName("아이브")
            .englishName("IVE")
            .image("abc")
            .country("KOREA")
            .artistGender(ArtistGender.WOMAN)
            .artistType(ArtistType.GROUP)
            .build();
    }
}
