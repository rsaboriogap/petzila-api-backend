package com.petzila.api.exception.mapper;

import com.petzila.api.model.response.XError;
import com.petzila.api.model.response.XStatusType;

import javax.annotation.Priority;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.USER)
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        XError xe = new XError();
        xe.setCode(300);
        xe.setStatus(XStatusType.ERROR);
        xe.getData().setMessage(exception.getMessage());
        return Response.status(415).entity(xe).build();
    }
}
