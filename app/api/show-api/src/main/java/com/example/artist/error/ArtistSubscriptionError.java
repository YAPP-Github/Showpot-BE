package com.example.artist.error;

import org.example.exception.BusinessError;

public enum ArtistSubscriptionError implements BusinessError {

    ARTIST_NOT_EXIST {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "ASB-001";
        }

        @Override
        public String getClientMessage() {
            return "구독하려는 아티스트가 존재하지 않습니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청으로 들어온 아티스트 ID에 해당하는 아티스트가 존재하지 않습니다.";
        }
    }
}
