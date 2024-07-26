package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.example.QueryTest;
import org.example.dto.artist.response.ArtistSearchResponse;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistSearch;
import org.example.fixture.ArtistFixture;
import org.example.repository.artist.ArtistRepository;
import org.example.repository.artist.artistsearch.ArtistSearchRepository;
import org.example.util.StringNormalizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

class ArtistSearchRepositoryTest extends QueryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistSearchRepository artistSearchRepository;

    @ParameterizedTest
    @ValueSource(strings = {"아이브", "IVE"})
    @DisplayName("한국이름, 영어이름과 일치하는 아티스트를 검색할 수 있다.")
    void searchArtistByKoreanNameAndEnglishName(String name) {
        //given
        Artist artist = ArtistFixture.artist();
        artistRepository.save(artist);

        List<ArtistSearch> artistSearches = artist.toArtistSearch();
        artistSearchRepository.saveAll(artistSearches);

        String searchName = StringNormalizer.removeWhitespaceAndLowerCase(name);

        //when
        Optional<ArtistSearchResponse> result = artistSearchRepository.searchArtist(searchName);

        //then
        assertThat(result).isNotEmpty();
    }
}
