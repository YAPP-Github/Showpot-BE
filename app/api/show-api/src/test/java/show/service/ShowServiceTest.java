package show.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.publish.MessagePublisher;
import com.example.show.service.ShowService;
import org.assertj.core.api.SoftAssertions;
import org.example.usecase.TicketingAlertUseCase;
import org.example.usecase.show.ShowUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import show.fixture.dto.ShowRequestDtoFixture;
import show.fixture.dto.ShowResponseDtoFixture;

class ShowServiceTest {

    private final ShowUseCase showUseCase = mock(ShowUseCase.class);
    private final TicketingAlertUseCase ticketingAlertUseCase = mock(TicketingAlertUseCase.class);
    private final MessagePublisher messagePublisher = mock(MessagePublisher.class);
    private final ShowService showService = new ShowService(
        showUseCase,
        ticketingAlertUseCase,
        messagePublisher
    );

    @Test
    @DisplayName("페이지네이션을 이용해 공연을 검색 할 수 있다.")
    void showSearchWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        String search = "testShowName";
        var request = ShowRequestDtoFixture.showSearchPaginationServiceRequest(size, search);
        given(
            showUseCase.searchShow(request.toDomainRequest())
        ).willReturn(
            ShowResponseDtoFixture.showSearchPaginationDomainResponse(size, hasNext)
        );

        //when
        var result = showService.searchShow(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

    @Test
    @DisplayName("공연 검색 결과가 없으면 빈 리스트를 반환한다.")
    void showSearchEmptyResultWithPagination() {
        //given
        int size = 2;
        String search = "testShowName";
        var request = ShowRequestDtoFixture.showSearchPaginationServiceRequest(size, search);
        given(
            showUseCase.searchShow(request.toDomainRequest())
        ).willReturn(
            ShowResponseDtoFixture.emptyDataShowSearchPaginationDomainResponse()
        );

        //when
        var result = showService.searchShow(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data()).isEmpty();
                soft.assertThat(result.hasNext()).isFalse();
            }
        );
    }

}
