package com.example.artist.error;

import org.example.exception.BusinessError;

public enum ArtistError implements BusinessError {
    ENTITY_NOT_FOUND {
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
    }
}
