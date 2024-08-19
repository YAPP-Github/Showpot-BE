package org.example.service;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.service.dto.response.NumberOfInterestShowServiceResponse;
import org.example.service.dto.response.NumberOfSubscribedArtistServiceResponse;
import org.example.service.dto.response.NumberOfSubscribedGenreServiceResponse;
import org.example.service.dto.response.NumberOfTicketingAlertServiceResponse;
import org.example.usecase.UserShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserShowService {

    private final UserShowUseCase userShowUseCase;

    public NumberOfTicketingAlertServiceResponse countAlertShows(UUID userId, LocalDateTime now) {
        long numberOfTicketingAlert = userShowUseCase.countAlertShows(userId, now);

        return NumberOfTicketingAlertServiceResponse.from(numberOfTicketingAlert);
    }

    public NumberOfSubscribedArtistServiceResponse countSubscribedArtists(UUID userId) {
        return NumberOfSubscribedArtistServiceResponse.from(
            userShowUseCase.countSubscribedArtists(userId)
        );
    }

    public NumberOfSubscribedGenreServiceResponse countSubscribedGenres(UUID uuid) {
        return NumberOfSubscribedGenreServiceResponse.from(
            userShowUseCase.countSubscribedGenres(uuid)
        );
    }

    public NumberOfInterestShowServiceResponse countInterestShows(UUID uuid) {
        return NumberOfInterestShowServiceResponse.from(
            userShowUseCase.countInterestShows(uuid)
        );
    }
}
