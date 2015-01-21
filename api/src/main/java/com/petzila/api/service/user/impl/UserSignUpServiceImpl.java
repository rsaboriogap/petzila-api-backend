package com.petzila.api.service.user.impl;

import com.petzila.api.domain.User;
import com.petzila.api.mapper.XSignUpMapper;
import com.petzila.api.model.XSignUp;
import com.petzila.api.service.user.UserFinder;
import com.petzila.api.service.user.UserSignUpService;
import com.petzila.api.utils.CloudinaryUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserSignUpServiceImpl implements UserSignUpService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserFinder userFinder;
    @Inject
    private CloudinaryUtils cloudinaryUtils;
    @Inject
    private XSignUpMapper signUpMapper;

    @Override
    public User signUp(XSignUp signUp) {
//        User newUser = signUpMapper.convertFrom(signUp);
//        if (signUp.getSignupType() == XSignUpType.LOCAL) {
//            User dbUser = userFinder.getByEmail(signUp.getEmail());
//            if (dbUser != null) {
//                if (!StringUtils.isBlank(dbUser.getSocialNetworkId())) {
//                    throw new ValidationException(664);
//                }
//                throw new ValidationException(619);
//            } else {
//                try {
//                    Map cloudinaryResponse = cloudinaryUtils.uploadImage(newUser.getProfilePicture());
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//
//        }
        return null;
    }
}
