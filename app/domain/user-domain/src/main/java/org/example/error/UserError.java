package org.example.error;

import org.example.exception.BusinessError;

public enum UserError implements BusinessError {

    NOT_FOUND_USER {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "USR-001";
        }

        @Override
        public String getClientMessage() {
            return "존재하지 않는 유저입니다.";
        }

        @Override
        public String getLogMessage() {
            return "조회 대상 유저가 존재하지 않습니다.";
        }
    }
}
