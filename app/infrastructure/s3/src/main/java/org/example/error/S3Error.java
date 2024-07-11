package org.example.error;

import org.example.exception.BusinessError;

public enum S3Error implements BusinessError {
    FILE_UPLOAD_ERROR {
        @Override
        public int getHttpStatus() {
            return 500;
        }

        @Override
        public String getErrorCode() {
            return "S3-001";
        }

        @Override
        public String getClientMessage() {
            return "파일 업로드 중 오류가 발생했습니다.";
        }

        @Override
        public String getLogMessage() {
            return "S3에 파일 업로드 실패 오류";
        }
    }


}
