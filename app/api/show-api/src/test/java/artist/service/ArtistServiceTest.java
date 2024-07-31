package artist.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import artist.fixture.domain.ArtistSubscriptionFixture;
import artist.fixture.dto.ArtistRequestDtoFixture;
import artist.fixture.dto.ArtistResponseDtoFixture;
import com.example.artist.service.ArtistService;
import org.assertj.core.api.SoftAssertions;
import org.example.entity.ArtistSubscription;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.artist.ArtistUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArtistServiceTest {

    private final ArtistUseCase artistUseCase = mock(ArtistUseCase.class);
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase = mock(
        ArtistSubscriptionUseCase.class);
    private final ArtistService artistService = new ArtistService(
        artistUseCase,
        artistSubscriptionUseCase
    );

    @Test
    @DisplayName("페이지네이션을 이용해 아티스트를 검색할 수 있다.")
    void artistSearchWithPagination() {
        //given
        String search = "testArtistName";
        int size = 3;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistSearchPaginationServiceRequest(size, search);
        given(
            artistUseCase.searchArtist(request.toDomainRequest())
        ).willReturn(
            ArtistResponseDtoFixture.artistDetailPaginationDomainResponse(size, hasNext)
        );

        //when
        var result = artistService.searchArtist(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

    @Test
    @DisplayName("아티스트 검색 결과가 없으면 빈 리스트를 반환한다.")
    void artistSearchEmptyResultWithPagination() {
        //given
        String search = "testArtistName";
        int size = 3;
        var request = ArtistRequestDtoFixture.artistSearchPaginationServiceRequest(size, search);
        given(
            artistUseCase.searchArtist(request.toDomainRequest())
        ).willReturn(
            ArtistResponseDtoFixture.emptyDataArtistDetailPaginationDomainResponse()
        );

        //when
        var result = artistService.searchArtist(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data()).isEmpty();
                soft.assertThat(result.hasNext()).isFalse();
            }
        );
    }

    @Test
    @DisplayName("페이지네이션을 이용해 아티스트를 필터링 할 수 있다.")
    void artistFilterWithPagination() {
        //given
        int subscriptionCount = 2;
        int size = 3;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistFilterPaginationServiceRequest(size);
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(subscriptionCount);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream().map(ArtistSubscription::getArtistId)
            .toList();
        given(
            artistUseCase.findAllArtistInCursorPagination(
                request.toDomainRequest(subscriptionArtistIds))
        ).willReturn(
            ArtistResponseDtoFixture.artistFilterPaginationDomainResponse(size, hasNext)
        );

        //when
        var result = artistService.filterArtist(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

    @Test
    @DisplayName("아티스트 필터링 결과가 없으면 빈 리스트를 반환한다.")
    void artistFilterEmptyResultWithPagination() {
        //given
        int subscriptionCount = 2;
        int size = 3;
        var request = ArtistRequestDtoFixture.artistFilterPaginationServiceRequest(size);
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(subscriptionCount);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream().map(ArtistSubscription::getArtistId)
            .toList();
        given(
            artistUseCase.findAllArtistInCursorPagination(
                request.toDomainRequest(subscriptionArtistIds))
        ).willReturn(
            ArtistResponseDtoFixture.emptyDataArtistFilterPaginationDomainResponse()
        );

        //when
        var result = artistService.filterArtist(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data()).isEmpty();
                soft.assertThat(result.hasNext()).isFalse();
            }
        );
    }
}
