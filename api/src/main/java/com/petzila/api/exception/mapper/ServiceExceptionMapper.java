package com.petzila.api.exception.mapper;

import com.petzila.api.exception.ServiceException;
import com.petzila.api.model.response.XError;
import com.petzila.api.model.response.XStatusType;
import com.petzila.api.util.ApiUtils;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {
    @Override
    public Response toResponse(ServiceException se) {
        XError error = new XError();
        error.setStatus(XStatusType.ERROR);
        error.setCode(se.getErrorCode().code());
        error.getData().setMessage(ApiUtils.getError(se.getMessage()));
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}