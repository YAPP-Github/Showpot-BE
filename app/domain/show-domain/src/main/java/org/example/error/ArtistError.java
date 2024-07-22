package org.example.error;

import org.example.exception.BusinessError;

public enum ArtistError implements BusinessError {
    ENTITY_NOT_FOUND_ERROR {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "ART-001";
        }

        @Override
        public String getClientMessage() {
            return "존재하지 않은 아티스트입니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청 값이 잘못 처리되었습니다.";
        }
    },

    SEARCH_NOT_FOUND_ERROR {
        @Override
        public int getHttpStatus() {
            return 400;
        }

        @Override
        public String getErrorCode() {
            return "ART-002";
        }

        @Override
        public String getClientMessage() {
            return "검색 조건이 일치하지 않습니다.";
        }

        @Override
        public String getLogMessage() {
            return "검색 요청 값이 잘못 처리되었습니다.";
        }
    }

}
