package org.example.usecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowDomainRequest;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.request.UninterestedShowDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.ArtistSubscription;
import org.example.entity.InterestShow;
import org.example.repository.interest.InterestShowRepository;
import org.example.repository.subscription.artistsubscription.ArtistSubscriptionRepository;
import org.example.repository.subscription.genresubscription.GenreSubscriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserShowUseCase {

    private final InterestShowRepository interestShowRepository;
    private final ArtistSubscriptionRepository artistSubscriptionRepository;
    private final GenreSubscriptionRepository genreSubscriptionRepository;

    @Transactional
    public void interest(InterestShowDomainRequest request) {
        findOptionalInterestShowByShowIdAndUserId(request.showId(), request.userId())
            .ifPresentOrElse(
                InterestShow::interest,
                () -> interestShowRepository.save(
                    InterestShow.builder()
                        .showId(request.showId())
                        .userId(request.userId())
                        .build()
                )
            );
    }

    @Transactional
    public void notInterest(UninterestedShowDomainRequest request) {
        findOptionalInterestShowByShowIdAndUserId(
            request.showId(),
            request.userId()
        ).ifPresent(InterestShow::uninterested);
    }

    public Optional<InterestShow> findInterestShow(UUID showId, UUID userId) {
        return interestShowRepository.findByShowIdAndUserIdAndIsDeletedFalse(showId, userId);
    }

    public List<ArtistSubscription> findArtistSubscriptionByUserId(UUID userId) {
        return artistSubscriptionRepository.findAllByUserIdAndIsDeletedFalse(userId);
    }

    public InterestShowPaginationDomainResponse findInterestShows(InterestShowPaginationDomainRequest request) {
        return interestShowRepository.findInterestShowList(request);
    }

    public long countAlertShows(UUID userId, LocalDateTime now) {
        return interestShowRepository.countValidTicketingAlerts(userId, now);
    }

    public long countSubscribedArtists(UUID userId) {
        Long result = artistSubscriptionRepository.countByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }

    public long countSubscribedGenres(UUID userId) {
        Long result = genreSubscriptionRepository.countByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }

    public long countInterestShows(UUID userId) {
        Long result = interestShowRepository.countInterestShowByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }

    private Optional<InterestShow> findOptionalInterestShowByShowIdAndUserId(UUID showId, UUID userId) {
        return interestShowRepository.findByShowIdAndUserId(showId, userId);
    }
}
