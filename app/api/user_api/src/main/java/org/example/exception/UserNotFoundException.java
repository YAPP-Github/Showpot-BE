package org.example.exception;

import org.example.error.ErrorCode;
import org.example.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND_EXCEPTION);
    }
}
