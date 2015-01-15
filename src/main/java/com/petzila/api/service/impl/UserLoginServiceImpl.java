package com.petzila.api.service.impl;

import com.petzila.api.domain.Identity;
import com.petzila.api.model.XIdentity;
import com.petzila.api.service.UserLoginService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rylexr on 15/01/15.
 */
@Stateless
public class UserLoginServiceImpl implements UserLoginService {
    @PersistenceContext
    private EntityManager em;

    public Identity doSomething(XIdentity identity) {
        return null;
    }
}
