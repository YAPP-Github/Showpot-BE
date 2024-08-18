package org.example.usecase;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowDomainRequest;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
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
    public InterestShow interest(InterestShowDomainRequest request) {
        Optional<InterestShow> optInterestShow = interestShowRepository.findByShowIdAndUserId(
            request.showId(),
            request.userId()
        );

        if (optInterestShow.isEmpty()) {
            return interestShowRepository.save(
                InterestShow.builder()
                    .showId(request.showId())
                    .userId(request.userId())
                    .build()
            );
        }

        InterestShow interestShow = optInterestShow.get();
        interestShow.interest();

        return interestShow;
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
}
