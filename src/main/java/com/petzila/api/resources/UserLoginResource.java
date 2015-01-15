package com.petzila.api.resources;

import com.petzila.api.model.XIdentity;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rsaborio on 16/12/14.
 */
@Path(Versions.V1_0 + "/user")
public interface UserLoginResource {
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response login(XIdentity identity);
}
