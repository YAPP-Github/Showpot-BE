package org.example.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.show.Show;
import org.example.property.AlarmServerProperty;
import org.example.repository.show.ShowRepository;
import org.example.repository.user.UserRepository;
import org.example.service.dto.response.NotificationExistServiceResponse;
import org.example.service.dto.response.NotificationPaginationResponse;
import org.example.service.dto.response.NotificationPaginationResponse.NotificationInfoResponse;
import org.example.service.dto.response.NotificationServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAlarmService {

    private final UserRepository userRepository;
    private final AlarmServerProperty alarmServerProperty;
    private final ShowRepository showRepository;

    public NotificationExistServiceResponse getNotificationExist(UUID userId) {
        String userFcmToken = findUserFcmTokenById(userId);

        ResponseEntity<NotificationExistServiceResponse> result = RestClient.builder()
            .baseUrl(alarmServerProperty.apiURL() + "/show-alarm/checked?fcmToken=" + userFcmToken)
            .build()
            .get()
            .retrieve()
            .toEntity(NotificationExistServiceResponse.class);

        handleApiError(result, "getNotificationExist");
        return result.getBody();
    }

    public NotificationServiceResponse findNotifications(UUID userId, UUID cursorId, int size) {
        String userFcmToken = findUserFcmTokenById(userId);

        ResponseEntity<NotificationPaginationResponse> result = RestClient.builder()
            .baseUrl(createNotificationsUrl(userFcmToken, cursorId, size))
            .build()
            .post()
            .retrieve()
            .toEntity(NotificationPaginationResponse.class);

        handleApiError(result, "findNotifications");
        var response = result.getBody();

        if (response != null) {
            List<UUID> showIds = response.data().stream()
                .map(NotificationInfoResponse::showId)
                .toList();
            List<Show> shows = showRepository.findShowsByIdInAndIsDeletedFalse(showIds);

            return NotificationServiceResponse.of(response, shows);
        }

        return NotificationServiceResponse.noneData();
    }

    private String createNotificationsUrl(String userFcmToken, UUID cursorId, int size) {
        StringBuilder urlBuilder = new StringBuilder(alarmServerProperty.apiURL())
            .append("/show-alarm?fcmToken=")
            .append(userFcmToken)
            .append("&size=")
            .append(size);

        if (cursorId != null) {
            urlBuilder.append("&cursorId=").append(cursorId);
        }

        return urlBuilder.toString();
    }

    private String findUserFcmTokenById(UUID userId) {
        return userRepository.findUserFcmTokensByUserId(userId)
            .orElseThrow(NoSuchElementException::new);
    }

    private void handleApiError(ResponseEntity<?> response, String methodName) {
        if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            log.error("Alarm Server API failed in {}: {}", methodName, response);
            throw new RuntimeException("Alarm Server API failed");
        }
    }
}
