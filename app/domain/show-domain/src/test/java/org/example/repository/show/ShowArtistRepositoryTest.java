package org.example.repository.show;

import org.assertj.core.api.SoftAssertions;
import org.example.QueryTest;
import org.example.entity.artist.Artist;
import org.example.entity.show.Show;
import org.example.fixture.domain.ArtistFixture;
import org.example.fixture.domain.ShowArtistFixture;
import org.example.fixture.domain.ShowFixture;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.show.showartist.ShowArtistRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowArtistRepositoryTest extends QueryTest {

    @Autowired
    private ShowArtistRepository showArtistRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    @DisplayName("공연과 연관된 아티스트 이름을 함께 가져온다.")
    void findArtistNamesWithShowId() {
        //given
        var artists = ArtistFixture.manSoloArtists(2);
        artistRepository.saveAll(artists);

        var shows = ShowFixture.shows(2);
        showRepository.saveAll(shows);

        var showArtist = ShowArtistFixture.showArtists(
            shows.stream().map(Show::getId).toList(),
            artists.stream().map(Artist::getId).toList(),
            2
        );
        showArtistRepository.saveAll(showArtist);

        //when
        var result = showArtistRepository.findArtistNamesWithShowId();

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.size()).isEqualTo(2);
                soft.assertThat(result.get(0).artistNameDomainResponses().size()).isEqualTo(1);
            }
        );
    }
}
