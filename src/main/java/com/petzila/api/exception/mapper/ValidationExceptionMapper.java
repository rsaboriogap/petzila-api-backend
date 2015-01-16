package com.petzila.api.exception.mapper;

import com.petzila.api.exception.ValidationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 16/01/15.
 */
@Provider
public class ValidationExceptionMapper  implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getPetzilaResponse()).build();
    }
}
