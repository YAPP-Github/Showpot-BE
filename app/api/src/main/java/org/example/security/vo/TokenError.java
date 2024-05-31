package org.example.security.vo;

import exception.BusinessError;

public enum TokenError implements BusinessError {

    WRONG_HEADER {
        @Override
        public int getHttpStatus() {
            return 401;
        }

        @Override
        public String getErrorCode() {
            return "TKN-001";
        }

        @Override
        public String getClientMessage() {
            return "유효하지 않은 토큰입니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청 헤더가 잘못 처리되었습니다.";
        }
    },

    EXPIRED_TOKEN {
        @Override
        public int getHttpStatus() {
            return 401;
        }

        @Override
        public String getErrorCode() {
            return "TKN-002";
        }

        @Override
        public String getClientMessage() {
            return "토큰이 만료되었습니다.";
        }

        @Override
        public String getLogMessage() {
            return "토큰이 만료되었습니다.";
        }
    },

    INVALID_TOKEN {
        @Override
        public int getHttpStatus() {
            return 401;
        }

        @Override
        public String getErrorCode() {
            return "TKN-003";
        }

        @Override
        public String getClientMessage() {
            return "유효하지 않은 토큰입니다.";
        }

        @Override
        public String getLogMessage() {
            return "만료 이외의 토큰 오류가 발생했습니다.";
        }
    },

    INVALID_CLAIM {
        @Override
        public int getHttpStatus() {
            return 401;
        }

        @Override
        public String getErrorCode() {
            return "TKN-003";
        }

        @Override
        public String getClientMessage() {
            return "유효하지 않은 토큰입니다.";
        }

        @Override
        public String getLogMessage() {
            return "토큰 claim 구성에 오류가 있습니다.";
        }
    }
}
