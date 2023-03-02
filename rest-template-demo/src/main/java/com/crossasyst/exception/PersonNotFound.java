package com.crossasyst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFound extends RuntimeException{

    public PersonNotFound(HttpStatus internalServerError, String statusText) {
        super(statusText);
    }
}
