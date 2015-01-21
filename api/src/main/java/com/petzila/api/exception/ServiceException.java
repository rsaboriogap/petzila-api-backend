package com.petzila.api.exception;

import com.petzila.api.utils.ErrorCode;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {
    private ErrorCode errorCode;
    private Object[] arguments;

    public ServiceException(ErrorCode errorCode, Object[] arguments) {
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public ServiceException(ErrorCode  errorCode) {
        this(errorCode, null);
    }

    public String getMessage() {
        return "@TODO"; //@TODO sacar del archivo de mensajes
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object[] getArguments() {
        return arguments;
    }
}