package org.example.usecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowDomainRequest;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.InterestShow;
import org.example.entity.TicketingAlert;
import org.example.repository.interest.InterestShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserShowUseCase {

    private final InterestShowRepository interestShowRepository;

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

    public List<TicketingAlert> countAlertShows(UUID userId, LocalDateTime now) {
        return interestShowRepository.findValidTicketingAlerts(userId, now);
    }
}
