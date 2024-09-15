package show.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.component.ViewCountComponent;
import com.example.show.service.ShowService;
import java.util.UUID;
import org.assertj.core.api.SoftAssertions;
import org.example.usecase.InterestShowUseCase;
import org.example.usecase.ShowUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import show.fixture.dto.ShowRequestDtoFixture;
import show.fixture.dto.ShowResponseDtoFixture;

class ShowServiceTest {

    private final ShowUseCase showUseCase = mock(ShowUseCase.class);
    private final InterestShowUseCase interestShowUseCase = mock(InterestShowUseCase.class);
    private final ViewCountComponent viewCountComponent = mock(ViewCountComponent.class);
    private final ShowService showService = new ShowService(
        showUseCase,
        interestShowUseCase,
        viewCountComponent
    );

    @Test
    @DisplayName("공연 상세 조회할 때 조회수를 올리고 데이터를 반환한다.")
    void showDetailWithUpViewCount() {
        //given
        UUID userId = UUID.randomUUID();
        UUID showId = UUID.randomUUID();
        String viewIdentifier = "testIdentifier";
        given(
            showUseCase.findShowDetail(showId)
        ).willReturn(
            ShowResponseDtoFixture.showDetailDomainResponse()
        );

        given(
            viewCountComponent.validateViewCount(showId, viewIdentifier)
        ).willReturn(true);

        //when
        var result = showService.getShow(userId, showId, viewIdentifier);

        //then
        verify(showUseCase, times(1)).view(showId);
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("공연 상세 조회할 때 조회수를 올리지 않고 데이터를 반환한다.")
    void showDetailNoneUpViewCount() {
        //given
        UUID userId = UUID.randomUUID();
        UUID showId = UUID.randomUUID();
        String viewIdentifier = "testIdentifier";
        given(
            showUseCase.findShowDetail(showId)
        ).willReturn(
            ShowResponseDtoFixture.showDetailDomainResponse()
        );

        given(
            viewCountComponent.validateViewCount(showId, viewIdentifier)
        ).willReturn(false);

        //when
        var result = showService.getShow(userId, showId, viewIdentifier);

        //then
        verify(showUseCase, times(0)).view(showId);
        assertThat(result).isNotNull();
    }

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
