package org.spring.boot.examples.testing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)//400
public class ResourceFormatException extends RuntimeException {

    public ResourceFormatException(Exception e) {
        super(e);
    }

    public ResourceFormatException(String message) {
        super(message);
    }
}
