package org.example.repository.show;

import org.assertj.core.api.SoftAssertions;
import org.example.QueryTest;
import org.example.entity.show.Show;
import org.example.entity.show.ShowTicketingTime;
import org.example.fixture.domain.ShowFixture;
import org.example.fixture.domain.ShowTicketingTimeFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowRepositoryTest extends QueryTest {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowTicketingTimeRepository showTicketingTimeRepository;

    @Test
    @DisplayName("공연 정보들은 연관된 티켓팅 시간과 함께 가져온다.")
    void findShowDetailWithTicketingTimes() {
        //given
        Show show = ShowFixture.deafultShow();
        showRepository.save(show);

        ShowTicketingTime showNormalTicketingTime = ShowTicketingTimeFixture.showNormalTicketingTime(show);
        ShowTicketingTime showPreTicketingTime = ShowTicketingTimeFixture.showPreTicketingTime(show);
        showTicketingTimeRepository.save(showNormalTicketingTime);
        showTicketingTimeRepository.save(showPreTicketingTime);


        //when
        var result = showRepository.findShowDetailWithTicketingTimes();

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.size()).isEqualTo(1);
                soft.assertThat(result.get(0).ticketingTimes().size()).isEqualTo(2);
            }
        );
    }

}
