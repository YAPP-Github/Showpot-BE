package com.example.show.error;

import org.example.exception.BusinessError;

public enum ShowError implements BusinessError {

    TICKETING_ALERT_RESERVED_ERROR {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "SHW-001";
        }

        @Override
        public String getClientMessage() {
            return "해당 공연의 티켓팅 알림을 설정할 수 없습니다.";
        }

        @Override
        public String getLogMessage() {
            return "해당 공연의 티켓팅 시간에 설정할 수 있는 알림 시간이 없습니다.";
        }
    }
}
