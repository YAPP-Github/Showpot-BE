package artist.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import artist.fixture.dto.ArtistRequestDtoFixture;
import artist.fixture.dto.ArtistResponseDtoFixture;
import com.example.artist.service.ArtistService;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import com.example.pub.MessagePublisher;
import com.example.pub.message.ArtistSubscriptionServiceMessage;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.SoftAssertions;
import org.example.entity.artist.Artist;
import org.example.entity.usershow.ArtistSubscription;
import org.example.fixture.domain.ArtistFixture;
import org.example.fixture.domain.ArtistSubscriptionFixture;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.ArtistUseCase;
import org.example.usecase.UserUseCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArtistServiceTest {

    private final ArtistUseCase artistUseCase = mock(ArtistUseCase.class);
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase = mock(
        ArtistSubscriptionUseCase.class
    );
    private final UserUseCase userUseCase = mock(UserUseCase.class);
    private final MessagePublisher messagePublisher = mock(MessagePublisher.class);

    private final ArtistService artistService = new ArtistService(
        artistUseCase,
        artistSubscriptionUseCase,
        userUseCase,
        messagePublisher
    );

    @Disabled
    @Test
    @DisplayName("페이지네이션을 이용해 아티스트를 검색할 수 있다.")
    void artistSearchWithPagination() {
        //given
        String search = "testArtistName";
        int size = 3;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistSearchPaginationServiceRequest(size, search);

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

    @Disabled
    @Test
    @DisplayName("아티스트 검색 결과가 없으면 빈 리스트를 반환한다.")
    void artistSearchEmptyResultWithPagination() {
        //given
        String search = "testArtistName";
        int size = 3;
        var request = ArtistRequestDtoFixture.artistSearchPaginationServiceRequest(size, search);

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
        var request = ArtistRequestDtoFixture.artistUnsubscriptionPaginationServiceRequest(size);
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

    @Test
    @DisplayName("아티스트 필터링 결과가 없으면 빈 리스트를 반환한다.")
    void artistFilterEmptyResultWithPagination() {
        //given
        int subscriptionCount = 2;
        int size = 3;
        var request = ArtistRequestDtoFixture.artistUnsubscriptionPaginationServiceRequest(size);
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
            ArtistResponseDtoFixture.emptyDataArtistPaginationDomainResponse()
        );

        //when
        var result = artistService.findArtistUnsubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data()).isEmpty();
                soft.assertThat(result.hasNext()).isFalse();
            }
        );
    }

    @Test
    @DisplayName("아티스트를 구독하면 구독 성공한 아티스트 ID들을 반환한다.")
    void artistSubscribe() {
        //given
        List<String> spotifyArtistsId = List.of("123", "456");
        UUID userId = UUID.randomUUID();
        var request = new ArtistSubscriptionServiceRequest(spotifyArtistsId, userId);
        var existArtistsInRequest = ArtistFixture.manSoloArtists(2);
        given(
            artistUseCase.findOrCreateArtistBySpotifyId(request.spotifyArtistIds())
        ).willReturn(
            existArtistsInRequest
        );

        var existArtistIdsInRequest = existArtistsInRequest.stream()
            .map(Artist::getId)
            .toList();
        int artistSubscriptionCount = 3;
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
                    .isEqualTo(existArtistsInRequest.size());
            }
        );
    }

    @Test
    @DisplayName("아티스트를 구독하면 구독 성공한 아티스트 ID들을 메시지 발행한다.")
    void artistSubscribePublishMessage() {
        //given
        List<String> spotifyArtistsId = List.of("123", "456");
        UUID userId = UUID.randomUUID();
        var request = new ArtistSubscriptionServiceRequest(spotifyArtistsId, userId);
        var existArtistsInRequest = ArtistFixture.manSoloArtists(3);
        given(
            artistUseCase.findOrCreateArtistBySpotifyId(request.spotifyArtistIds())
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
        assertThat(result).isNotNull();
        verify(messagePublisher, times(1)).publishArtistSubscription(
            eq("artistSubscription"),
            any(ArtistSubscriptionServiceMessage.class)
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
    @DisplayName("아티스트를 구독 취소하면 구독 취소 성공한 아티스트 ID들을 메시지 발행한다.")
    void artistUnsubscribePublishMessage() {
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
        assertThat(result).isNotNull();
        verify(messagePublisher, times(1))
            .publishArtistSubscription(
                eq("artistUnsubscription"),
                any(ArtistSubscriptionServiceMessage.class)
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

    @Test
    @DisplayName("페이지네이션을 이용해 비회원도 구독하지 않은 아티스트를 조회할 수 있다.")
    void artistUnsubscribeForNonUserWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        var request = ArtistRequestDtoFixture.artistUnsubscriptionPaginationServiceRequest(size);

        given(
            artistUseCase.findAllArtistInCursorPagination(
                request.toDomainRequest(List.of())
            )
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
