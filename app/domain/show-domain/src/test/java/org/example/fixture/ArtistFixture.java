package org.example.fixture;

import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

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
}
