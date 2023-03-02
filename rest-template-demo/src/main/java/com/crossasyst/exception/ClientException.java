package com.crossasyst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ClientException extends HttpClientErrorException {

    public ClientException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }


}
