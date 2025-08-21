package com.example.summarizer.common.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GeneralException extends Exception {
    public HttpStatus status;

    private GeneralException() {}
    public GeneralException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
