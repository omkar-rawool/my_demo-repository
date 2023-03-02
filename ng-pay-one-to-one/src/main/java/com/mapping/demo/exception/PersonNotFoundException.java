package com.mapping.demo.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String s) {
        super(s);
    }
}
