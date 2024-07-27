package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.QueryTest;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.entity.show.Show;
import org.example.entity.show.ShowSearch;
import org.example.fixture.ShowFixture;
import org.example.repository.show.ShowRepository;
import org.example.repository.show.ShowSearchRepository;
import org.example.util.StringNormalizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowSearchRepositoryTest extends QueryTest {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSearchRepository showSearchRepository;


    @Test
    @DisplayName("공연이름과 일치하는 공연을 검색할 수 있다.")
    void searchShowByShowName() {
        //given
        Show show = ShowFixture.deafultShow();
        showRepository.save(show);

        ShowSearch showSearch = show.toShowSearch();
        showSearchRepository.save(showSearch);

        ShowSearchPaginationDomainRequest request = ShowSearchPaginationDomainRequest.builder()
            .cursor(null)
            .size(2)
            .search(StringNormalizer.removeWhitespaceAndLowerCase(show.getTitle()))
            .build();

        //when
        ShowSearchPaginationDomainResponse result = showSearchRepository.searchShow(request);

        //then
        assertThat(result.data()).isNotEmpty();
    }

}
