package org.example.exception;

public record ErrorResponse(
    String errorId,
    String errorCode,
    String message,
    int httpStatus
) {

    public ErrorResponse(String errorId, String errorCode, String message, int httpStatus) {
        this.errorId = errorId;
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private ErrorResponse(BusinessErrorResponseBuilder builder) {
        this(
            builder.errorId,
            builder.error.getErrorCode(),
            builder.error.getClientMessage(),
            builder.error.getHttpStatus()
        );
    }

    private ErrorResponse(MessageCustomErrorResponseBuilder builder) {
        this(
            builder.errorId,
            builder.error.getErrorCode(),
            builder.message,
            builder.error.getHttpStatus()
        );
    }

    public static BusinessErrorResponseBuilder businessErrorResponseBuilder() {
        return new BusinessErrorResponseBuilder();
    }

    public static MessageCustomErrorResponseBuilder messageCustomErrorResponseBuilder() {
        return new MessageCustomErrorResponseBuilder();
    }

    public static class BusinessErrorResponseBuilder {

        private String errorId;
        private BusinessError error;

        protected BusinessErrorResponseBuilder() {
        }

        public BusinessErrorResponseBuilder errorId(String errorId) {
            this.errorId = errorId;
            return this;
        }

        public BusinessErrorResponseBuilder error(BusinessError error) {
            this.error = error;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

    public static class MessageCustomErrorResponseBuilder {

        private String errorId;
        private String message;
        private BusinessError error;

        protected MessageCustomErrorResponseBuilder() {
        }

        public MessageCustomErrorResponseBuilder errorId(String errorId) {
            this.errorId = errorId;
            return this;
        }

        public MessageCustomErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MessageCustomErrorResponseBuilder error(BusinessError error) {
            this.error = error;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
