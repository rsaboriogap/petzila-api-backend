package com.petzila.api.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {
    private String message;
    private int code;
    private Object[] arguments;

    public ServiceException(String message, int code, Object[] arguments) {
        this.message = message;
        this.code = code;
        this.arguments = arguments;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Object[] getArguments() {
        return arguments;
    }
}