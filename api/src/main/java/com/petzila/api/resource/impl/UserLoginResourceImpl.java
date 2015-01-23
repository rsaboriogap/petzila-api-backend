package com.petzila.api.resource.impl;

import com.petzila.api.domain.User;
import com.petzila.api.mapper.XLoginMapper;
import com.petzila.api.model.XLogin;
import com.petzila.api.model.response.XLoginResponse;
import com.petzila.api.resource.UserLoginResource;
import com.petzila.api.service.UserLoginService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Response;

@Stateless
public class UserLoginResourceImpl implements UserLoginResource {
    @Inject
    private UserLoginService userLoginService;
    @Inject
    private XLoginMapper loginMapper;

    @Override
    public Response login(@Valid XLogin login) {
        User u = userLoginService.login(login);
        XLoginResponse xlr = loginMapper.map(u);
        return Response.ok()
                .entity(xlr)
                .build();
    }
}
