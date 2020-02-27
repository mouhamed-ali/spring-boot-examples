package org.spring.boot.examples.testing.exceptions;

/*
 * we will not used the @ResponseStatus annotation in this example and we will manage this in the controller.
 * using the @ResponseStatus we cannot return a response body. it will only return the http status code
 */
public class ResourceFormatException extends RuntimeException {

    public ResourceFormatException(Exception e) {
        super(e);
    }

    public ResourceFormatException(String message) {
        super(message);
    }
}
