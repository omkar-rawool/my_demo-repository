package com.mapping.demo.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;


public class BadRequestException extends HttpClientErrorException {


    public BadRequestException(String s){
        super(HttpStatus.valueOf(s));
    }


    public BadRequestException(String message, HttpStatus statusCode, String statusText, HttpHeaders headers, byte[] body, Charset responseCharset) {
        super(message, statusCode, statusText, headers, body, responseCharset);
    }
}
