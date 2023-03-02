package com.crossasyst.handler;

import com.crossasyst.exception.PersonNotFound;
import com.crossasyst.handler.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class MyExceptionHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return new DefaultResponseErrorHandler().hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {


       if(response.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR)
       {
           log.info(response.getStatusCode());
           throw new PersonNotFound(HttpStatus.INTERNAL_SERVER_ERROR,"Interval Server Error");
        }
       else if (response.getStatusCode()==HttpStatus.NOT_FOUND) {

           throw new PersonNotFound(HttpStatus.NOT_FOUND,"Person not found.");

       }else if (response.getStatusCode().is5xxServerError()){
           throw new PersonNotFound(HttpStatus.BAD_REQUEST,"Bad Request");

       }

    }


}
