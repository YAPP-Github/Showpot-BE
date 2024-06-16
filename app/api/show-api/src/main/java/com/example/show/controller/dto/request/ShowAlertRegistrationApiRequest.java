package com.example.show.controller.dto.request;

import com.example.show.controller.vo.ShowAlertTimeApiType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record ShowAlertRegistrationApiRequest(

    @Schema(description = "공연 티켓팅 알림 시간 선택")
    List<ShowAlertTimeApiType> alertTimes
) {

}
