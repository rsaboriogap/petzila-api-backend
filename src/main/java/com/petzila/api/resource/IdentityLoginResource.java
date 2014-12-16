package com.petzila.api.resource;

import com.codahale.metrics.annotation.Timed;
import com.petzila.api.dto.Login;
import com.petzila.api.dto.LoginResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by rsaborio on 16/12/14.
 */
@Path("/identity/login")
@Consumes(MediaType.APPLICATION_JSON)
public class IdentityLoginResource {

    @POST
    @Timed
    public Response login(Login login) {
        if ("foo@goo.com".equals(login.getEmail()) && "password".equals(login.getPassword())) {
            return Response.ok(new LoginResponse(UUID.randomUUID().toString())).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
