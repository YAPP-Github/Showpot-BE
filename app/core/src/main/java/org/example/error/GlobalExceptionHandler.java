package org.example.error;

import static org.example.error.ErrorCode.INPUT_INVALID_VALUE_ERROR;
import static org.example.error.ErrorCode.INTERNAL_SERVER_ERROR;
import static org.example.error.ErrorCode.REQUEST_PARAMETER_NOT_FOUND_ERROR;
import static org.example.error.ErrorCode.REQUEST_PARAMETER_TYPE_NOT_MATCH_ERROR;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.example.error.exception.BusinessException;
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
        log.error(e.getMessage(), e);

        final ErrorResponse errorResponse = ErrorResponse.fromErrorCode(
            INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR.getStatus())
            .body(errorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        log.error(e.getMessage(), e);

        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse errorResponse = ErrorResponse.fromErrorCode(errorCode);

        return ResponseEntity.status(errorCode.getStatus())
            .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleRequestArgumentNotValidException(
        MethodArgumentNotValidException e
    ) {
        log.warn(e.getMessage(), e);

        final ErrorResponse errorResponse = ErrorResponse.ofBindingResult(INPUT_INVALID_VALUE_ERROR,
            e.getBindingResult());
        return ResponseEntity.status(INPUT_INVALID_VALUE_ERROR.getStatus())
            .body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
        MissingServletRequestParameterException e
    ) {
        log.warn(e.getMessage(), e);

        final ErrorResponse errorResponse = ErrorResponse.fromParameter(
            REQUEST_PARAMETER_NOT_FOUND_ERROR,
            e.getParameterName());

        return ResponseEntity.status(REQUEST_PARAMETER_NOT_FOUND_ERROR.getStatus())
            .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
        MethodArgumentTypeMismatchException e
    ) {
        log.warn(e.getMessage(), e);

        final ErrorResponse errorResponse = ErrorResponse.fromType(
            REQUEST_PARAMETER_TYPE_NOT_MATCH_ERROR,
            e.getParameter().getParameterName(),
            String.valueOf(e.getValue())
        );

        return ResponseEntity.status(REQUEST_PARAMETER_TYPE_NOT_MATCH_ERROR.getStatus())
            .body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolationException(
        ConstraintViolationException e) {
        log.warn(e.getMessage(), e);

        final ErrorResponse errorResponse = ErrorResponse.ofConstraints(INPUT_INVALID_VALUE_ERROR,
            e.getConstraintViolations());

        return ResponseEntity.status(INPUT_INVALID_VALUE_ERROR.getStatus())
            .body(errorResponse);
    }
}
