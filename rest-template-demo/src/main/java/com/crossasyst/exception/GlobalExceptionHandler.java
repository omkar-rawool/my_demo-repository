package com.crossasyst.exception;

import com.crossasyst.handler.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice(basePackages = {"com.crossasyst"})
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFound.class)
 public ResponseEntity<ErrorResponse> personNotFoundHandler(Exception e, WebRequest request)
 {
     return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(),request.getDescription(false)),HttpStatus.NOT_FOUND);
 }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e, WebRequest request)
    {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(), request.getDescription(false)),HttpStatus.NOT_FOUND);
    }
}
