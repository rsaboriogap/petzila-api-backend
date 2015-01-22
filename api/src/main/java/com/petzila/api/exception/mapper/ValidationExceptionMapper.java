package com.petzila.api.exception.mapper;

import com.petzila.api.model.response.XError;
import com.petzila.api.model.response.XStatusType;

import javax.annotation.Priority;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.USER)
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception) {
        XError xe = new XError();
        xe.setStatus(XStatusType.ERROR);
        Exception e = (Exception) unwrap(exception);
        if (e != null) { // ConstraintViolationException found!
            xe.setCode(300); //@TODO sacarlo del constraintviolation
            xe.getData().setMessage(e.getMessage());
//            ConstraintViolationException cve = (ConstraintViolationException) e;
//            for (ConstraintViolation cv : ((ConstraintViolationException) e).getConstraintViolations()) {
//                cv.getMessage()
//            }
        } else {
            //@TODO que hacer si no es un constraintviolation ??
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(xe).build();
    }

    private static Throwable unwrap(Throwable t) {
        return doUnwrap(t);
    }

    private static Throwable doUnwrap(Throwable t) {
        if (t == null)
            return null;
        if (t instanceof ConstraintViolationException)
            return t;
        return doUnwrap(t.getCause());
    }
}
