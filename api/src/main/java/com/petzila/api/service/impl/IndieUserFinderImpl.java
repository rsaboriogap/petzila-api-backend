package com.petzila.api.service.impl;

import com.petzila.api.service.IndieUserFinder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class IndieUserFinderImpl implements IndieUserFinder {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean isFounder(String email) {
        try {
            return (Long) em.createNamedQuery("IndieUser.isFounder(email)")
                    .setParameter(1, email)
                    .getSingleResult() > 0;
        } catch (NoResultException nre) {
            return false;
        }
    }
}
