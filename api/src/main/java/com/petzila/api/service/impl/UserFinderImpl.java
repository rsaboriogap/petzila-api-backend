package com.petzila.api.service.impl;

import com.petzila.api.domain.User;
import com.petzila.api.exception.NotFoundException;
import com.petzila.api.service.UserFinder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.text.MessageFormat;

@Stateless
public class UserFinderImpl implements UserFinder {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User find(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User get(long id) {
        User u = find(id);
        if (u == null) {
            throw new NotFoundException(MessageFormat.format("User with id = {0} not found", id)); //@TODO externalizar en un properties
        }
        return u;
    }

    @Override
    public User findByEmail(String email) {
        try {
            return (User) em.createNamedQuery("User.findByEmail(email)")
                    .setParameter(1, email.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        User u = findByEmail(email);
        if (u == null) {
            throw new NotFoundException(MessageFormat.format("User with email = {0} not found", email)); //@TODO externalizar en un properties
        }
        return null;
    }
}
