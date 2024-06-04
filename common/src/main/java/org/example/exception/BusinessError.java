package org.example.exception;

public interface BusinessError {

    int getHttpStatus();

    String getErrorCode();

    String getClientMessage();

    String getLogMessage();
}
