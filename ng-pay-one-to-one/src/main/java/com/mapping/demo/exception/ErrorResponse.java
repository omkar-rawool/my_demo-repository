package com.mapping.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;
    private String path;



}
