package com.petzila.api.exception;

import com.petzila.api.util.ErrorCode;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class NotFoundException extends ServiceException {
    public NotFoundException(String message) {
        super(ErrorCode.ERROR_0); //@TODO code?? message??
    }
}
