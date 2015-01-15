package com.petzila.api.resources.impl;

import com.petzila.api.model.XIdentity;
import com.petzila.api.resources.UserLoginResource;
import com.petzila.api.service.UserLoginService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Created by rylexr on 15/01/15.
 */
@Stateless
public class UserLoginResourceImpl implements UserLoginResource {
    @Inject
    private UserLoginService userLoginService;

    @Override
    public Response login(XIdentity identity) {
        userLoginService.doSomething(identity);
        return Response.ok().build();
    }
}
