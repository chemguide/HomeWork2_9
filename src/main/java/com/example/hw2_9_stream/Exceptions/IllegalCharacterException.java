package com.example.hw2_9_stream.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalCharacterException extends RuntimeException {
    public IllegalCharacterException() {
        super();
    }
}
