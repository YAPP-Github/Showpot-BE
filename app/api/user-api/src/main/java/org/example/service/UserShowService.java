package org.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.entity.TicketingAlert;
import org.example.service.dto.response.TicketingAlertCountServiceResponse;
import org.example.usecase.UserShowUseCase;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserShowService {

    private final UserShowUseCase userShowUseCase;
    private final ShowUseCase showUseCase;

    public TicketingAlertCountServiceResponse countAlertShows(UUID userId, LocalDateTime now) {
        Map<UUID, List<TicketingAlert>> ticketingAlertByShowId = userShowUseCase.countAlertShows(userId, now).stream()
            .collect(Collectors.groupingBy(TicketingAlert::getShowId));

        return TicketingAlertCountServiceResponse.from(ticketingAlertByShowId.keySet().size());
    }
}
