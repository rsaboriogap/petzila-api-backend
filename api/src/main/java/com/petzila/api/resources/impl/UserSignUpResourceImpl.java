package com.petzila.api.resources.impl;

import com.petzila.api.domain.User;
import com.petzila.api.mapper.XSignUpMapper;
import com.petzila.api.model.XSignUp;
import com.petzila.api.model.response.XSignUpResponse;
import com.petzila.api.resources.UserSignUpResource;
import com.petzila.api.service.UserSignUpService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class UserSignUpResourceImpl implements UserSignUpResource {
    @Inject
    private UserSignUpService userSignUpService;
    @Inject
    private XSignUpMapper signUpMapper;

    @Override
    public Response signup(XSignUp signUp) {
        User u = userSignUpService.signUp(signUp);
        XSignUpResponse xsur = signUpMapper.map(u);
        return Response.status(Response.Status.CREATED)
                .entity(xsur)
                .build();
    }
}
