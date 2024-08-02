package artist.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import artist.fixture.dto.ArtistRequestDtoFixture;
import artist.fixture.dto.ArtistResponseDtoFixture;
import com.example.artist.service.ArtistService;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.assertj.core.api.SoftAssertions;
import org.example.entity.ArtistSubscription;
import org.example.entity.artist.Artist;
import org.example.fixture.ArtistSubscriptionFixture;
import org.example.fixture.domain.ArtistFixture;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.artist.ArtistUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArtistServiceTest {

    private final ArtistUseCase artistUseCase = mock(ArtistUseCase.class);
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase = mock(
        ArtistSubscriptionUseCase.class
    );
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

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
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

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
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

    @Test
    @DisplayName("아티스트 필터링한 총 개수를 반환한다.")
    void artistFilterToTalCount() {
        //given
        var request = ArtistRequestDtoFixture.artistFilterTotalCountServiceRequest();
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(2);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
        int totalCount = 3;
        given(
            artistUseCase.findFilterArtistTotalCount(request.toDomainRequest(subscriptionArtistIds))
        ).willReturn(
            ArtistResponseDtoFixture.artistFilterTotalCountDomainResponse(totalCount)
        );

        //when
        var result = artistService.filterArtistTotalCount(request);

        //then
        assertThat(result.totalCount()).isEqualTo(totalCount);
    }

    @Test
    @DisplayName("아티스트 필터링 후 결과가 없다면 0을 반환한다.")
    void artistFilterTotalCountZero() {
        //given
        var request = ArtistRequestDtoFixture.artistFilterTotalCountServiceRequest();
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(2);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
        given(
            artistUseCase.findFilterArtistTotalCount(request.toDomainRequest(subscriptionArtistIds))
        ).willThrow(
            NoSuchElementException.class
        );

        //when
        var result = artistService.filterArtistTotalCount(request);

        //then
        assertThat(result.totalCount()).isZero();
    }

    @Test
    @DisplayName("아티스트를 구독하면 구독 성공한 아티스트 ID들을 반환한다.")
    void artistSubscribe() {
        //given
        List<UUID> artistsId = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new ArtistSubscriptionServiceRequest(artistsId, userId);
        var existArtistsInRequest = ArtistFixture.manSoloArtists(3);
        given(
            artistUseCase.findAllArtistInIds(request.artistIds())
        ).willReturn(
            existArtistsInRequest
        );

        var existArtistIdsInRequest = existArtistsInRequest.stream()
            .map(Artist::getId)
            .toList();
        int artistSubscriptionCount = 2;
        given(
            artistSubscriptionUseCase.subscribe(existArtistIdsInRequest, userId)
        ).willReturn(
            ArtistSubscriptionFixture.artistSubscriptions(artistSubscriptionCount)
        );

        //when
        var result = artistService.subscribe(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result).isNotNull();
                soft.assertThat(result.successSubscriptionArtistIds().size())
                    .isEqualTo(artistSubscriptionCount);
            }
        );
    }

    @Test
    @DisplayName("아티스트를 구독 취소하면 구독 취소 성공한 아티스트 ID들을 반환한다.")
    void artistUnsubscribe() {
        //given
        List<UUID> artistsId = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new ArtistUnsubscriptionServiceRequest(artistsId, userId);
        int artistSubscriptionCount = 2;
        given(
            artistSubscriptionUseCase.unsubscribe(request.artistIds(), userId)
        ).willReturn(
            ArtistSubscriptionFixture.artistSubscriptions(artistSubscriptionCount)
        );

        //when
        var result = artistService.unsubscribe(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result).isNotNull();
                soft.assertThat(result.successUnsubscriptionArtistIds().size())
                    .isEqualTo(artistSubscriptionCount);
            }
        );
    }

    @Test
    @DisplayName("페이지네이션을 이용해 구독한 아티스트를 반환한다.")
    void artistSubscribeWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistSubscriptionPaginationServiceRequest(size);
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(3);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
        given(
            artistUseCase.findAllArtistInCursorPagination(
                request.toDomainRequest(subscriptionArtistIds))
        ).willReturn(
            ArtistResponseDtoFixture.artistPaginationDomainResponse(size, hasNext)
        );

        //when
        var result = artistService.findArtistSubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

    @Test
    @DisplayName("구독한 아티스트가 없을 경우 빈 리스트를 반환하다.")
    void artistSubscribeEmptyResultWithPagination() {
        //given
        int size = 2;
        var request = ArtistRequestDtoFixture.artistSubscriptionPaginationServiceRequest(size);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            List.of()
        );

        //when
        var result = artistService.findArtistSubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data()).isEmpty();
                soft.assertThat(result.hasNext()).isFalse();
            }
        );
    }

    @Test
    @DisplayName("페이지네이션을 이용해 구독하지 않은 아티스트를 반환한다.")
    void artistUnsubscribeWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistUnsubscriptionPaginationServiceRequest(size);
        var subscriptions = ArtistSubscriptionFixture.artistSubscriptions(2);
        given(
            artistSubscriptionUseCase.findSubscriptionList(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
        given(
            artistUseCase.findAllArtistInCursorPagination(
                request.toDomainRequest(subscriptionArtistIds))
        ).willReturn(
            ArtistResponseDtoFixture.artistPaginationDomainResponse(size, hasNext)
        );

        //when
        var result = artistService.findArtistUnsubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }
}
