package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.example.QueryTest;
import org.example.dto.show.ShowSearchDomainResponse;
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

        String searchName = StringNormalizer.removeWhitespaceAndLowerCase(show.getTitle());

        //when
        Optional<ShowSearchDomainResponse> result = showSearchRepository.searchShow(searchName);

        //then
        assertThat(result).isNotEmpty();
    }

}
