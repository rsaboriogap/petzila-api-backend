package com.petzila.api.resources.impl;

import com.petzila.api.domain.User;
import com.petzila.api.exception.ValidationException;
import com.petzila.api.model.XSignUp;
import com.petzila.api.model.XSignUpType;
import com.petzila.api.resources.UserSignUpResource;
import com.petzila.api.service.user.UserSignupService;
import com.petzila.api.utils.DataUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class UserSignUpResourceImpl implements UserSignUpResource {
    @Inject
    private UserSignupService userSignupService;
    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public Response signup(XSignUp signUp) {
        if (signUp == null) {
            throw new ValidationException(901);
        } else if (signUp.getSignupType() == null) {
            throw new ValidationException(612);
        } else if (signUp.getSignupType() != XSignUpType.FACEBOOK || signUp.getSignupType() != XSignUpType.LOCAL) {
            throw new ValidationException(613);
        } else if (signUp.getSignupType() == XSignUpType.LOCAL && StringUtils.isBlank(signUp.getEmail())) {
            throw new ValidationException(613);
        } else if (signUp.getSignupType() == XSignUpType.FACEBOOK &&
                StringUtils.isBlank(signUp.getSocialNetworkID())) {
            throw new ValidationException(604);
        } else if (signUp.getSignupType() == XSignUpType.LOCAL && StringUtils.isBlank(signUp.getPassword())) {
            throw new ValidationException(603);
        } else if (StringUtils.isBlank(signUp.getUsername())) {
            throw new ValidationException(610);
        } else if (StringUtils.isBlank(signUp.getProfilePicture())) {
            throw new ValidationException(620);
        } else if (!StringUtils.isBlank(signUp.getProfilePicture()) && signUp.getResourceType() == null) {
            throw new ValidationException(623);
        } else if (!DataUtils.supportedTypes.containsKey(signUp.getResourceType().value())) {
            throw new ValidationException(625);
        } else if (!StringUtils.isBlank(signUp.getFacebookToken()) && signUp.getFacebookTokenType() == null) {
            throw new ValidationException(661);
        } else if (signUp.getUsername().length() < 2 || signUp.getUsername().length() > 20) {
            throw new ValidationException(616);
        } else if (signUp.getName() != null && !StringUtils.isBlank(signUp.getName().getFirstName()) && (signUp.getName().getFirstName().length() < 2 || signUp.getName().getFirstName().length() > 70)) {
            throw new ValidationException(646);
        } else if (signUp.getName() != null && !StringUtils.isBlank(signUp.getName().getLastName()) && (signUp.getName().getLastName().length() < 2 || signUp.getName().getLastName().length() > 70)) {
            throw new ValidationException(647);
        } else if (!StringUtils.isBlank(signUp.getDescription()) && signUp.getDescription().length() > 200) {
            throw new ValidationException(618);
        } else if (StringUtils.isBlank(signUp.getEmail())) {
            throw new ValidationException(602);
        } else if (!emailValidator.isValid(signUp.getEmail())) {
            throw new ValidationException(614);
        } else if (!StringUtils.isBlank(signUp.getPassword()) && (signUp.getPassword().length() < 8 || signUp.getPassword().length() > 70)) {
            throw new ValidationException(615);
        }

        if (signUp.getSignupType() == XSignUpType.LOCAL) {
            signUp.setFacebookToken(null);
            signUp.setSocialNetworkID(null);
            signUp.setFacebookTokenType(null);
        }

        if (signUp.getSignupType() == XSignUpType.LOCAL) {//local signup
            User newUser = userSignupService.signUp(signUp);

        } else if (signUp.getSignupType() == XSignUpType.FACEBOOK) {

        }

        return Response.status(Response.Status.CREATED).entity(null).build();
    }
}
