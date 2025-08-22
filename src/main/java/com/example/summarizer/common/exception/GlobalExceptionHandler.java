package com.example.summarizer.common.exception;

import com.example.summarizer.common.logging.GeneralLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private GeneralLogger logger = new GeneralLogger(GlobalExceptionHandler.class);

    private Map<String, Object> createErrorResponse(String error, HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", error);
        body.put("message", message);
        body.put("status", status.value());
        return body;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        Optional<Throwable> throwable = Optional.ofNullable(ex.getCause());
        Map<String, Object> errorResponse = createErrorResponse(
                throwable.orElse(new GeneralException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)).getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        );
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleGeneralExceptions(GeneralException ex, WebRequest request) {
        Optional<Throwable> throwable = Optional.ofNullable(ex.getCause());
        Map<String, Object> errorResponse = createErrorResponse(
                throwable.orElse(new GeneralException(ex.getMessage(), ex.getStatus())).getMessage(),
                ex.getStatus(),
                ex.getMessage()
        );
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
