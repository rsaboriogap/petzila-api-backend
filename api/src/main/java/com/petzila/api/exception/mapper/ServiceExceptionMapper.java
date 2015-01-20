package com.petzila.api.exception.mapper;

import com.petzila.api.exception.ServiceException;
import com.petzila.api.model.XPetzilaResponse;
import com.petzila.api.model.XResponseType;
import com.petzila.api.utils.ApiUtils;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Override
    public Response toResponse(ServiceException se) {
        XPetzilaResponse petzilaResponse = new XPetzilaResponse();

        if (se.getCode() != 0) {
            petzilaResponse.setMessage(ApiUtils.getError(se.getCode() + ""));
        } else {
            petzilaResponse.setMessage(ApiUtils.getError("920"));
        }

        petzilaResponse.setCode(se.getCode());
        petzilaResponse.setStatus(XResponseType.ERROR);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(petzilaResponse).build();
    }
}