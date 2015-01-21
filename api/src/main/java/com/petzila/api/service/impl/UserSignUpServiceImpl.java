package com.petzila.api.service.impl;

import com.petzila.api.domain.SignUpType;
import com.petzila.api.domain.User;
import com.petzila.api.exception.ServiceException;
import com.petzila.api.model.XSignUp;
import com.petzila.api.service.IndieUserFinder;
import com.petzila.api.service.UserFinder;
import com.petzila.api.service.UserSignUpService;
import com.petzila.api.utils.ErrorCode;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class UserSignUpServiceImpl implements UserSignUpService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserFinder userFinder;
    @Inject
    private IndieUserFinder indieUserFinder;
//    @Inject
//    private CloudinaryUtils cloudinaryUtils;
//    @Inject
//    private XSignUpMapper signUpMapper;

    @Override
    public User signUp(XSignUp signUp) {
        switch (signUp.getSignupType()) {
            case FACEBOOK:
                return signUpWithFacebook(signUp);
            case LOCAL:
            default:
                return signUpLocal(signUp);
        }

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
//        return null;
    }

    private User signUpLocal(XSignUp signUp) {
        User u = userFinder.findByEmail(signUp.getEmail());
        if (u != null) {
            if (StringUtils.isBlank(u.getSocialNetworkId())) {
                throw new ServiceException(ErrorCode.ERROR_614);
            }
            throw new ServiceException(ErrorCode.ERROR_619);
        }

        u = new User();
        u.setFirstName(signUp.getName().getFirstName());
        u.setLastName(signUp.getName().getLastName());
        u.setActive(false);
        u.setFounder(indieUserFinder.isFounder(signUp.getEmail()));
        u.setSignupType(SignUpType.LOCAL);
        u.setCreatedAt(new Date());
        em.persist(u);
        return u;
    }

    private User signUpWithFacebook(XSignUp signUp) {
        return null;
    }
}
