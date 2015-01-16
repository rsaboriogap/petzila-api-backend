package com.petzila.api.resources.impl;

import com.petzila.api.model.XSignupRequest;
import com.petzila.api.resources.UserSignupResource;
import com.petzila.api.service.UserSignupService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Created by vicente on 16/01/15.
 */
@Stateless
public class UserSignupResourceImpl implements UserSignupResource {

    @Inject
    private UserSignupService userSignupService;

    @Override
    public Response signup(XSignupRequest signupRequest) {
       return Response.ok().build();
    }
}
