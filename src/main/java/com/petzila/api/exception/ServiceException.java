package com.petzila.api.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {
    private String message;
    private Object[] arguments;

    public ServiceException(String message, Object... arguments) {
        this.message = message;
        this.arguments = arguments;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArguments() {
        return arguments;
    }
}