package com.petzila.api.service.user.impl;

import com.petzila.api.domain.User;
import com.petzila.api.service.user.UserFinderService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by vicente on 16/01/15.
 */
public class UserFinderServiceImpl implements UserFinderService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User getById(long id) {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.id=?1").setParameter(1, id).getSingleResult();
        }catch(NoResultException nrex){
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.email=?1").setParameter(1, email).getSingleResult();
        }catch(NoResultException nrex){
            return null;
        }
    }

    @Override
    public Boolean existsEmail(String email) {
            Long count= (Long) em.createQuery("SELECT COUNT(u) FROM User u WHERE u.email=?1").setParameter(1, email).getSingleResult();
            return count > 0;
    }
}
