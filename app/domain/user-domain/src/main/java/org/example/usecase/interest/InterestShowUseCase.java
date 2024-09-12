package org.example.usecase.interest;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowDomainRequest;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.InterestShow;
import org.example.repository.interest.InterestShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InterestShowUseCase {

    private final InterestShowRepository interestShowRepository;

    @Transactional
    public InterestShow interest(InterestShowDomainRequest request) {
        Optional<InterestShow> optInterestShow = findInterestShowByShowIdAndUserId(
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

    public Optional<InterestShow> findInterestShow(UUID showId, UUID userId) {
        return interestShowRepository.findByShowIdAndUserIdAndIsDeletedFalse(showId, userId);
    }

    public InterestShowPaginationDomainResponse findInterestShows(
        InterestShowPaginationDomainRequest request) {
        return interestShowRepository.findInterestShowList(request);
    }

    public long countInterestShows(UUID userId) {
        Long result = interestShowRepository.countInterestShowByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }

    private Optional<InterestShow> findInterestShowByShowIdAndUserId(UUID showId, UUID userId) {
        return interestShowRepository.findByShowIdAndUserId(showId, userId);
    }
}
