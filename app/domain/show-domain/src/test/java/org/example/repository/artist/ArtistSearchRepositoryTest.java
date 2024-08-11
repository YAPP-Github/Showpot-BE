package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.example.QueryTest;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistSearch;
import org.example.fixture.domain.ArtistFixture;
import org.example.repository.artist.artistsearch.ArtistSearchRepository;
import org.example.util.StringNormalizer;
import org.example.vo.ArtistSortType;
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
    void searchArtistByKoreanNameAndEnglishName(String search) {
        //given
        Artist artist = ArtistFixture.womanGroup();
        artistRepository.save(artist);

        List<ArtistSearch> artistSearches = artist.toArtistSearch();
        artistSearchRepository.saveAll(artistSearches);

        ArtistSearchPaginationDomainRequest request = ArtistSearchPaginationDomainRequest.builder()
            .sortStandard(ArtistSortType.ENGLISH_NAME_ASC)
            .cursor(null)
            .size(2)
            .search(StringNormalizer.removeWhitespaceAndLowerCase(search))
            .build();

        //when
        var result = artistSearchRepository.searchArtist(request);

        assertThat(result.data()).isNotEmpty();
    }
}
