package com.petzila.api.mapper;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignUp;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import javax.ejb.Stateless;

/**
 * Created by vicente on 16/01/15.
 */
@Stateless
public class XSignupRequestUserMapper {
    private Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    public User convertFrom(XSignUp signUp) {
        User user = mapper.map(signUp, User.class);
        if (signUp.getName() != null) {
            user.setFirstName(signUp.getName().getFirstName());
            user.setLastName(signUp.getName().getLastName());
        }

        if (signUp.getLocation() != null) {
            user.setCountry(signUp.getLocation().getCountry());
            user.setCity(signUp.getLocation().getCity());
            user.setZipCode(signUp.getLocation().getZipCode());
        }
        return user;
    }
}
