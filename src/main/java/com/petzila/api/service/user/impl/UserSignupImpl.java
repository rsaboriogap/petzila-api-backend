package com.petzila.api.service.user.impl;

import com.petzila.api.domain.User;
import com.petzila.api.exception.ValidationException;
import com.petzila.api.mapper.XSignupRequestUserMapper;
import com.petzila.api.model.XSignUp;
import com.petzila.api.model.XSignUpType;
import com.petzila.api.service.user.UserFinderService;
import com.petzila.api.service.user.UserSignupService;
import com.petzila.api.utils.CloudinaryUtils;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.Map;

@Stateless
public class UserSignupImpl implements UserSignupService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserFinderService userFinderService;
    @Inject
    private CloudinaryUtils cloudinaryUtils;
    @Inject
    private XSignupRequestUserMapper signupRequestUserMapper;

    @Override
    public User signUp(XSignUp signUp) {
        User newUser = signupRequestUserMapper.convertFrom(signUp);
        if (signUp.getSignupType() == XSignUpType.LOCAL) {
            User dbUser = userFinderService.getByEmail(signUp.getEmail());
            if (dbUser != null) {
                if (!StringUtils.isBlank(dbUser.getSocialNetworkId())) {
                    throw new ValidationException(664);
                }
                throw new ValidationException(619);
            } else {
                try {
                    Map cloudinaryResponse = cloudinaryUtils.uploadImage(newUser.getProfilePicture());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {

        }
        return null;
    }
}
