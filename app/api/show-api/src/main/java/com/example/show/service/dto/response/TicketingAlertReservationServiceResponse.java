package com.example.show.service.dto.response;

import com.example.show.controller.vo.TicketingAlertTimeApiType;
import com.example.show.service.dto.param.TicketingAlertReservationTimeServiceParam;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import org.example.entity.usershow.TicketingAlert;

@Builder
public record TicketingAlertReservationServiceResponse(
    List<TicketingAlertReservationTimeServiceParam> times
) {

    public static TicketingAlertReservationServiceResponse as(
        LocalDateTime ticketingAt,
        List<TicketingAlert> reservedAlerts,
        LocalDateTime now
    ) {
        Set<TicketingAlertTimeApiType> distinctAlertTimes = reservedAlerts.stream()
            .map(alert -> {
                int minutesGap = (int) Duration.between(alert.getAlertTime(), ticketingAt).toMinutes();
                return TicketingAlertTimeApiType.getTicketingAlertTimeByMinutesGap(minutesGap);
            }).collect(Collectors.toSet());

        return new TicketingAlertReservationServiceResponse(
            Arrays.stream(TicketingAlertTimeApiType.values())
                .map(alertTimeType -> {
                        LocalDateTime alertTime = ticketingAt.minusMinutes(alertTimeType.getMinutes());

                        if (alertTime.isBefore(now)) {
                            return TicketingAlertReservationTimeServiceParam.builder()
                                .time(alertTimeType)
                                .isReserved(false)
                                .canReserve(false)
                                .build();
                        }

                        return TicketingAlertReservationTimeServiceParam.builder()
                            .time(alertTimeType)
                            .isReserved(distinctAlertTimes.contains(alertTimeType))
                            .canReserve(true)
                            .build();
                    }
                ).toList()
        );
    }
}
