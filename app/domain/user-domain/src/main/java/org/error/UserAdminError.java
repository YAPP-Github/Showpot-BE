package org.error;

import org.example.exception.BusinessError;

public enum UserAdminError implements BusinessError {
    ENTITY_NOT_FOUND_ERROR {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "UAM-001";
        }

        @Override
        public String getClientMessage() {
            return "존재하지 않은 어드민입니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청 값이 잘못 처리되었습니다.";
        }
    },
    ADMIN_NOT_AUTHORITY_ERROR {
        @Override
        public int getHttpStatus() {
            return 403;
        }

        @Override
        public String getErrorCode() {
            return "UAM-002";
        }

        @Override
        public String getClientMessage() {
            return "권한이 없는 사용자입니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청 값이 잘못 처리되었습니다.";
        }
    }

}
