package com.petzila.api.mapper;

import com.petzila.api.domain.Identity;
import com.petzila.api.model.XIdentity;

import javax.ejb.Stateless;

@Stateless
public class IdentityMapper {
    public XIdentity map(Identity identity) {
        XIdentity xi = new XIdentity();
        xi.setAuthToken(identity.getAuthToken());
        return xi;
    }
}
