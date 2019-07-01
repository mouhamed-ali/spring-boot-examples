package org.spring.boot.examples.testing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//404
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Exception e) {
        super(e);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
