package com.petzila.api.mapper;

import com.petzila.api.domain.User;
import com.petzila.api.model.response.XSignUpResponse;
import org.dozer.Mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class XSignUpMapper {
    @Inject
    private Mapper mapper;

    public XSignUpResponse map(User user) {
        XSignUpResponse xsur = new XSignUpResponse();
        xsur.setData(mapper.map(user, XSignUpResponse.XData.class));
        return xsur;
    }

//    public User convertFrom(XSignUp signUp) {
//        User user = mapper.map(signUp, User.class);
//        if (signUp.getName() != null) {
//            user.setFirstName(signUp.getName().getFirstName());
//            user.setLastName(signUp.getName().getLastName());
//        }
//
//        if (signUp.getLocation() != null) {
//            user.setCountry(signUp.getLocation().getCountry());
//            user.setCity(signUp.getLocation().getCity());
//            user.setZipCode(signUp.getLocation().getZipCode());
//        }
//        return user;
//    }
}
