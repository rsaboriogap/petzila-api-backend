package com.petzila.api.mapper;

import com.petzila.api.domain.User;
import com.petzila.api.model.response.XLoginResponse;
import org.dozer.Mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class XLoginMapper {
    @Inject
    private Mapper mapper;

    public XLoginResponse map(User user) {
        XLoginResponse xlr = new XLoginResponse();
        xlr.setData(mapper.map(user, XLoginResponse.XData.class));
        return xlr;
    }
}
