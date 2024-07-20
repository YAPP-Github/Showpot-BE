package org.example.error;

import org.example.exception.BusinessError;

public enum AdminError implements BusinessError {
    EMAIL_DUPLICATED_ERROR {
        @Override
        public int getHttpStatus() {
            return 409;
        }

        @Override
        public String getErrorCode() {
            return "ADM-001";
        }

        @Override
        public String getClientMessage() {
            return "이 이메일은 이미 사용 중입니다. 다른 이메일을 입력해 주세요.";
        }

        @Override
        public String getLogMessage() {
            return "데이터베이스에 이미 존재하는 이메일로 요청이 들어왔습니다.";
        }
    }
}
