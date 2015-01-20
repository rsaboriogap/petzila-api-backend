package com.petzila.api.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class NotFoundException extends ServiceException {
    public NotFoundException(String message) {
        super(message, 100, null); //@TODO code??
    }
}
