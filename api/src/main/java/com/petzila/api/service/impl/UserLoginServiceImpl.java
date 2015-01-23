package com.petzila.api.service.impl;

import com.petzila.api.domain.User;
import com.petzila.api.model.XLogin;
import com.petzila.api.service.UserLoginService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserLoginServiceImpl implements UserLoginService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User login(XLogin login) {
        return null; //@TODO
    }
}
