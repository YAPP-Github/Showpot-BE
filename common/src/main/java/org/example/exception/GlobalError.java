package org.example.exception;

public enum GlobalError implements BusinessError {

    INTERNAL_SERVER_ERROR {
        @Override
        public int getHttpStatus() {
            return 500;
        }

        @Override
        public String getErrorCode() {
            return "GLOBAL-001";
        }

        @Override
        public String getClientMessage() {
            return "서버에 예기치 못한 에러가 발생했습니다.";
        }

        @Override
        public String getLogMessage() {
            return "서버에 예기치 못한 에러가 발생했습니다.";
        }
    },

    INPUT_INVALID_VALUE {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "GLOBAL-002";
        }

        @Override
        public String getClientMessage() {
            return "잘못된 입력 값입니다.";
        }

        @Override
        public String getLogMessage() {
            return "잘못된 입력 값입니다.";
        }
    },

    REQUEST_PARAM_NOT_FOUND {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "GLOBAL-003";
        }

        @Override
        public String getClientMessage() {
            return "필수 파라미터가 존재하지 않습니다.";
        }

        @Override
        public String getLogMessage() {
            return "필수 파라미터가 존재하지 않습니다.";
        }
    },

    REQUEST_PARAM_TYPE_MISMATCH {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "GLOBAL-004";
        }

        @Override
        public String getClientMessage() {
            return "파라마티 타입이 일치하지 않습니다.";
        }

        @Override
        public String getLogMessage() {
            return "파라마티 타입이 일치하지 않습니다.";
        }
    }
}
