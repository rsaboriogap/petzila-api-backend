package com.petzila.api.mapper;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignupRequest;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import javax.ejb.Stateless;

/**
 * Created by vicente on 16/01/15.
 */
@Stateless
public class XSignupRequestUserMapper {
    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public User convertFrom(XSignupRequest signupRequest){
        User user = mapper.map(signupRequest, User.class);
        if(signupRequest.getName()!=null){
            user.setFirstName(signupRequest.getName().getFirstName());
            user.setLastName(signupRequest.getName().getLastName());
        }

        if(signupRequest.getLocation()!=null){
            user.setCountry(signupRequest.getLocation().getCountry());
            user.setCity(signupRequest.getLocation().getCity());
            user.setZipCode(signupRequest.getLocation().getZipCode());
        }
        return user;

    }

}
