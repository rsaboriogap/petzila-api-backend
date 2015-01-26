package com.petzila.api.exception.mapper;

import com.petzila.api.model.response.XError;
import com.petzila.api.model.response.XStatusType;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// Resteasy Specific implementation
@Provider
public class ResteasyViolationExceptionMapper implements ExceptionMapper<ResteasyViolationException> {
    @Override
    public Response toResponse(ResteasyViolationException exception) {
        // @TODO hacer que verifique si es un parameter, class, field, etc. violation
        String message = exception.getParameterViolations().get(0).getMessage();
        int code = Integer.parseInt(message.substring(0, message.indexOf('|')));
        message = message.substring(message.indexOf('|') + 1);

        XError xe = new XError();
        xe.setStatus(XStatusType.ERROR);
        xe.setCode(code);
        xe.getData().setMessage(message);
        return Response.status(Response.Status.BAD_REQUEST).entity(xe).build();
    }
}
