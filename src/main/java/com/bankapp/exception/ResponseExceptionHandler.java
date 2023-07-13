package com.bankapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorExtension> handleNotFoundException(Exception ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage()
        );
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(MapperException.class)
    public ResponseEntity<ErrorExtension> handleMapperException(Exception ex) {
        ErrorExtension body = new ErrorExtension(
                ex.getMessage()
        );
        return new ResponseEntity<>(body, NOT_FOUND);
    }
}
