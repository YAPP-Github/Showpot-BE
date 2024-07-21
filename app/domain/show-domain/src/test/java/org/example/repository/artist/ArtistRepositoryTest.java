package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.example.entity.artist.Artist;
import org.example.fixture.ArtistFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("show-domain-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    @DisplayName("findAllInIds 메서드가 의도대로 동작하는지 확인한다.")
    void find_all_in() {
        var artists = artistRepository.saveAll(
            List.of(
                ArtistFixture.test(),
                ArtistFixture.test()
            )
        );

        ArrayList<UUID> ids = new ArrayList<>(artists.stream().map(Artist::getId).toList());
        ids.add(UUID.randomUUID());

        List<Artist> findArtists = Assertions.assertDoesNotThrow(
            () -> artistRepository.findAllInIds(ids)
        );

        assertThat(findArtists).hasSize(2);
    }

    @Test
    @DisplayName("findAllInIds 메서드가 매칭되는 ID가 없을 때 빈 리스트를 반환한다.")
    void find_all_in_no_match() {

        ArrayList<UUID> ids = new ArrayList<>();
        ids.add(UUID.randomUUID());

        List<Artist> findArtists = Assertions.assertDoesNotThrow(
            () -> artistRepository.findAllInIds(ids)
        );

        assertThat(findArtists).hasSize(0);
    }
}