package genre.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.genre.service.GenreService;
import com.example.genre.service.dto.request.GenreSubscriptionServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionServiceRequest;
import com.example.pub.MessagePublisher;
import com.example.pub.message.GenreSubscriptionServiceMessage;
import genre.fixture.GenreRequestDtoFixture;
import genre.fixture.GenreResponseDtoFixture;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.SoftAssertions;
import org.example.entity.genre.Genre;
import org.example.entity.usershow.GenreSubscription;
import org.example.fixture.domain.GenreFixture;
import org.example.fixture.domain.GenreSubscriptionFixture;
import org.example.usecase.GenreSubscriptionUseCase;
import org.example.usecase.GenreUseCase;
import org.example.usecase.UserUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenreServiceTest {

    private final GenreUseCase genreUseCase = mock(GenreUseCase.class);
    private final GenreSubscriptionUseCase genreSubscriptionUseCase = mock(
        GenreSubscriptionUseCase.class
    );
    private final UserUseCase userUseCase = mock(UserUseCase.class);
    private final MessagePublisher messagePublisher = mock(MessagePublisher.class);

    private final GenreService genreService = new GenreService(
        genreUseCase,
        genreSubscriptionUseCase,
        userUseCase,
        messagePublisher
    );

    @Test
    @DisplayName("장르를 구독하면 구독 성공한 장르 ID들을 반환하다.")
    void genreSubscribe() {
        //given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new GenreSubscriptionServiceRequest(genreIds, userId);
        var existGenresInRequest = GenreFixture.genres(2);
        given(
            genreUseCase.findAllGenresInIds(request.genreIds())
        ).willReturn(
            existGenresInRequest
        );

        var existGenreIdsInRequest = existGenresInRequest.stream()
            .map(Genre::getId)
            .toList();
        int genreSubscriptionCount = 2;
        given(
            genreSubscriptionUseCase.subscribe(existGenreIdsInRequest, request.userId())
        ).willReturn(
            GenreSubscriptionFixture.genreSubscriptions(genreSubscriptionCount)
        );

        //when
        var result = genreService.subscribe(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result).isNotNull();
                soft.assertThat(result.successSubscriptionGenreIds().size())
                    .isEqualTo(genreSubscriptionCount);
            }
        );
    }

    @Test
    @DisplayName("장르를 구독하면 구독 성공한 장르 ID들을 메시지 발행하다.")
    void genreSubscribePublishMessage() {
        //given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new GenreSubscriptionServiceRequest(genreIds, userId);
        var existGenresInRequest = GenreFixture.genres(2);
        given(
            genreUseCase.findAllGenresInIds(request.genreIds())
        ).willReturn(
            existGenresInRequest
        );

        var existGenreIdsInRequest = existGenresInRequest.stream()
            .map(Genre::getId)
            .toList();
        int genreSubscriptionCount = 2;
        given(
            genreSubscriptionUseCase.subscribe(existGenreIdsInRequest, request.userId())
        ).willReturn(
            GenreSubscriptionFixture.genreSubscriptions(genreSubscriptionCount)
        );

        //when
        var result = genreService.subscribe(request);

        //then
        assertThat(result).isNotNull();
        verify(messagePublisher, times(1)).publishGenreSubscription(
            eq("genreSubscription"),
            any(GenreSubscriptionServiceMessage.class)
        );
    }

    @Test
    @DisplayName("장르를 구독 취소하면 구독 취소 성공한 장르 ID들을 반환하다.")
    void genreUnsubscribe() {
        //given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new GenreUnsubscriptionServiceRequest(genreIds, userId);
        int genreUnsubscriptionCount = 2;
        given(
            genreSubscriptionUseCase.unsubscribe(request.genreIds(), request.userId())
        ).willReturn(
            GenreSubscriptionFixture.genreSubscriptions(genreUnsubscriptionCount)
        );

        //when
        var result = genreService.unsubscribe(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result).isNotNull();
                soft.assertThat(result.successUnsubscriptionGenreIds().size())
                    .isEqualTo(genreUnsubscriptionCount);
            }
        );
    }

    @Test
    @DisplayName("장르를 구독 취소하면 구독 취소 성공한 장르 ID들을 메시지 발행한다.")
    void genreUnsubscribePublishMessage() {
        //given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());
        UUID userId = UUID.randomUUID();
        var request = new GenreUnsubscriptionServiceRequest(genreIds, userId);
        int genreUnsubscriptionCount = 2;
        given(
            genreSubscriptionUseCase.unsubscribe(request.genreIds(), request.userId())
        ).willReturn(
            GenreSubscriptionFixture.genreSubscriptions(genreUnsubscriptionCount)
        );

        //when
        var result = genreService.unsubscribe(request);

        //then
        assertThat(result).isNotNull();
        verify(messagePublisher, times(1))
            .publishGenreSubscription(
                eq("genreUnsubscription"),
                any(GenreSubscriptionServiceMessage.class)
            );
    }

    @Test
    @DisplayName("페이지네이션을 이용해 구독한 장르를 반환한다.")
    void genreSubscribeWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        var request = GenreRequestDtoFixture.genrePaginationServiceRequest(size);
        var subscriptions = GenreSubscriptionFixture.genreSubscriptions(3);
        given(
            genreSubscriptionUseCase.findSubscriptions(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();
        given(
            genreUseCase.findGenreWithCursorPagination(
                request.toDomainRequest(subscriptionGenreIds))
        ).willReturn(
            GenreResponseDtoFixture.genrePaginationDomainResponse(size, hasNext)
        );

        //when
        var result = genreService.findGenreSubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

    @Test
    @DisplayName("구독한 장르가 없을 경우 빈 리스트를 반환하다.")
    void genreSubscribeEmptyResultWithPagination() {
        //given
        int size = 2;
        var request = GenreRequestDtoFixture.genrePaginationServiceRequest(size);
        given(
            genreSubscriptionUseCase.findSubscriptions(request.userId())
        ).willReturn(
            List.of()
        );

        //when
        var result = genreService.findGenreSubscriptions(request);

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
    void genreUnsubscribeWithPagination() {
        //given
        int size = 2;
        boolean hasNext = true;
        var request = GenreRequestDtoFixture.genreUnsubscriptionPaginationServiceRequest(size);
        var subscriptions = GenreSubscriptionFixture.genreSubscriptions(3);
        given(
            genreSubscriptionUseCase.findSubscriptions(request.userId())
        ).willReturn(
            subscriptions
        );

        var subscriptionGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();

        given(
            genreUseCase.findGenreWithCursorPagination(
                request.toDomainRequest(subscriptionGenreIds)
            )
        ).willReturn(
            GenreResponseDtoFixture.genrePaginationDomainResponse(size, hasNext)
        );

        //when
        var result = genreService.findGenreUnSubscriptions(request);

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.data().size()).isEqualTo(size);
                soft.assertThat(result.hasNext()).isEqualTo(hasNext);
            }
        );
    }

}
