package org.example.error;

import org.example.exception.BusinessError;

public enum UserError implements BusinessError {

    // 0** 공통
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
    },

    // 1** 로그인
    WITHDREW_USER_LOGIN {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "USR-100";
        }

        @Override
        public String getClientMessage() {
            return "탈퇴한 유저는 로그인할 수 없습니다.";
        }

        @Override
        public String getLogMessage() {
            return "탈퇴한 유저는 로그인할 수 없습니다.";
        }
    }
}
