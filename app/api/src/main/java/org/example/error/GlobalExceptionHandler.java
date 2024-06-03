package org.example.error;

import jakarta.validation.ConstraintViolationException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.BusinessException;
import org.example.exception.ErrorResponse;
import org.example.exception.GlobalError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleGlobalException(final Exception e) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.businessErrorResponseBuilder()
            .errorId(errorId)
            .error(GlobalError.INTERNAL_SERVER_ERROR)
            .build();

        log.error(errorId, e);

        return ResponseEntity.internalServerError()
            .body(response);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.businessErrorResponseBuilder()
            .errorId(errorId)
            .error(e.error)
            .build();

        log.error(errorId, e);

        return ResponseEntity.status(response.httpStatus())
            .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleRequestArgumentNotValidException(
        MethodArgumentNotValidException e
    ) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.messageCustomErrorResponseBuilder()
            .errorId(errorId)
            .message(e.getMessage())
            .error(GlobalError.REQUEST_PARAM_NOT_FOUND)
            .build();

        log.error(errorId, e);

        return ResponseEntity.badRequest()
            .body(response);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
        MissingServletRequestParameterException e
    ) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.businessErrorResponseBuilder()
            .errorId(errorId)
            .error(GlobalError.REQUEST_PARAM_NOT_FOUND)
            .build();

        log.error(errorId, e);

        return ResponseEntity.badRequest()
            .body(response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
        MethodArgumentTypeMismatchException e
    ) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.businessErrorResponseBuilder()
            .errorId(errorId)
            .error(GlobalError.REQUEST_PARAM_TYPE_MISMATCH)
            .build();

        log.error(errorId, e);

        return ResponseEntity.badRequest()
            .body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolationException(
        ConstraintViolationException e
    ) {
        String errorId = UUID.randomUUID().toString();
        ErrorResponse response = ErrorResponse.messageCustomErrorResponseBuilder()
            .errorId(errorId)
            .message(e.getMessage())
            .error(GlobalError.INPUT_INVALID_VALUE)
            .build();

        log.error(errorId, e);

        return ResponseEntity.badRequest()
            .body(response);
    }
}
