package com.example.hw2_9_stream.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
        super();
    }
}
