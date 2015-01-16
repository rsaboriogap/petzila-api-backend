package com.petzila.api.service.impl;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignupRequest;
import com.petzila.api.service.UserSignupService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by vicente on 16/01/15.
 */
@Stateless
public class UserSignupImpl implements UserSignupService{

    @PersistenceContext
    private EntityManager em;


    @Override
    public User signup(XSignupRequest signupRequest) {
        return null;
    }
}
