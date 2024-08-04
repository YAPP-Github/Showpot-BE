package com.example.show.service.error;

import org.example.exception.BusinessError;

public enum ShowError implements BusinessError {

    DETAIL_NOT_FOUND {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "SHW-001";
        }

        @Override
        public String getClientMessage() {
            return "해당 공연을 찾을 수 없습니다.";
        }

        @Override
        public String getLogMessage() {
            return "공연 ID에 매칭되는 정보를 찾을 수 없습니다.";
        }
    }
}
