package com.mapping.demo.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex,WebRequest request)
    {

      return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(),request.getDescription(false)),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoPersonsAvailableException.class)
    public ResponseEntity<Object> handlePersonNotAvailable(NoPersonsAvailableException ex,WebRequest request)
    {

        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(),request.getDescription(false)),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotCreatePersonException.class)
    public ResponseEntity<Object> handleCreatePersonEx(CannotCreatePersonException ex,WebRequest request)
    {

        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalEx(Exception ex,WebRequest request)
    {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(),request.getDescription(false)),HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
