package org.example.exception;

public class BusinessException extends RuntimeException {

    public BusinessError error;

    public BusinessException(BusinessError error) {
        super(error.getClientMessage());
        this.error = error;
    }
}
