package com.petzila.api.exception.mapper;

import com.petzila.api.exception.ServiceException;
import com.petzila.api.model.XError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {
//    @Inject
//    private ServiceMessages serviceMessages;

    @Override
    public Response toResponse(ServiceException se) {
        XError xe = new XError();
//        xe.setMessage(serviceMessages.getMessage(se.getMessage(), se.getArguments()));
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(xe).build();
    }
}