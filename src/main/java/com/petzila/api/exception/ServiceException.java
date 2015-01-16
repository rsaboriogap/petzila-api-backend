package com.petzila.api.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {
    private String message;
    private Integer code;
    private Object[] arguments;

    public ServiceException(String message, Integer code, Object[] arguments) {
        this.message = message;
        this.code = code;
        this.arguments = arguments;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public Object[] getArguments() {
        return arguments;
    }
}