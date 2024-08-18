package org.example.service;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.service.dto.response.NumberOfSubscribedArtistServiceResponse;
import org.example.service.dto.response.NumberOfTicketingAlertServiceResponse;
import org.example.usecase.UserShowUseCase;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserShowService {

    private final UserShowUseCase userShowUseCase;
    private final ShowUseCase showUseCase;

    public NumberOfTicketingAlertServiceResponse countAlertShows(UUID userId, LocalDateTime now) {
        long numberOfTicketingAlert = userShowUseCase.countAlertShows(userId, now);

        return NumberOfTicketingAlertServiceResponse.from(numberOfTicketingAlert);
    }

    public NumberOfSubscribedArtistServiceResponse countSubscribedArtists(UUID userId) {
        return NumberOfSubscribedArtistServiceResponse.from(userShowUseCase.countSubscribedArtists(userId));
    }
}
