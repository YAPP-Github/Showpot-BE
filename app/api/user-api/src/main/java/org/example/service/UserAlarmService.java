package org.example.service;


import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.property.AlarmServerProperty;
import org.example.repository.user.UserRepository;
import org.example.service.dto.response.NotificationExistServiceResponse;
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

    public NotificationExistServiceResponse getNotificationExist(UUID userId) {
        String userFcmToken = userRepository.findUserFcmTokensByUserId(userId)
            .orElseThrow(NoSuchElementException::new);

        ResponseEntity<NotificationExistServiceResponse> result = RestClient.builder()
            .baseUrl(alarmServerProperty.apiURL() + "/show-alarm/checked?fcmToken=" + userFcmToken)
            .build()
            .get()
            .retrieve()
            .toEntity(NotificationExistServiceResponse.class);

        if (result.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            log.error("Alarm Server API failed: {}", result);
            throw new RuntimeException("Alarm Server API failed");
        }

        return result.getBody();
    }
}
