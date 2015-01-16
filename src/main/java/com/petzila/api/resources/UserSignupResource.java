package com.petzila.api.resources;

import com.petzila.api.model.XSignupRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by vicente on 16/01/15.
 */
@Path(Versions.V1_0 + "/user")
public interface UserSignupResource {

    @POST
    @Path("/signup")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response signup(XSignupRequest signupRequest);
}
