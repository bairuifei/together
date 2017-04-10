package com.together.exception;

/**
 * Created by BRF on 2017-04-10.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
