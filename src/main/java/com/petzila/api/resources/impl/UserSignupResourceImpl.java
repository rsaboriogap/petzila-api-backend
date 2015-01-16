package com.petzila.api.resources.impl;

import com.petzila.api.domain.User;
import com.petzila.api.exception.ValidationException;
import com.petzila.api.model.XSignupRequest;
import com.petzila.api.model.XSignupType;
import com.petzila.api.resources.UserSignupResource;
import com.petzila.api.service.user.UserSignupService;
import com.petzila.api.utils.DataUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Created by vicente on 16/01/15.
 */
@Stateless
public class UserSignupResourceImpl implements UserSignupResource {

    @Inject
    private UserSignupService userSignupService;

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public Response signup(XSignupRequest signupRequest) {
        if(signupRequest==null){
            throw new ValidationException(901);
        }else if(signupRequest.getSignupType() == null){
            throw new ValidationException(612);
        }else if(signupRequest.getSignupType()!=XSignupType.FACEBOOK || signupRequest.getSignupType()!=XSignupType.LOCAL){
            throw new ValidationException(613);
        }else if(signupRequest.getSignupType() == XSignupType.LOCAL && StringUtils.isBlank(signupRequest.getEmail())){
            throw new ValidationException(613);
        }else if(signupRequest.getSignupType()== XSignupType.FACEBOOK  &&
                StringUtils.isBlank(signupRequest.getSocialNetworkID())){
            throw new ValidationException(604);
        }else if(signupRequest.getSignupType() == XSignupType.LOCAL && StringUtils.isBlank(signupRequest.getPassword())){
            throw new ValidationException(603);
        }else if(StringUtils.isBlank(signupRequest.getUsername())){
            throw new ValidationException(610);
        }else if(StringUtils.isBlank(signupRequest.getProfilePicture())){
            throw new ValidationException(620);
        }else if(!StringUtils.isBlank(signupRequest.getProfilePicture()) && signupRequest.getResourceType() == null ){
            throw new ValidationException(623);
        }else if(!DataUtils.supportedTypes.containsKey(signupRequest.getResourceType().value())){
            throw new ValidationException(625);
        }else if(!StringUtils.isBlank(signupRequest.getFacebookToken())&& signupRequest.getFacebookTokenType() == null){
            throw new ValidationException(661);
        }else if(!StringUtils.isBlank(signupRequest.getFacebookToken()) && signupRequest.getFacebookTokenType() == null){
            throw new ValidationException(663);
        }else if(signupRequest.getUsername().length() < 2 || signupRequest.getUsername().length() > 20 ){
            throw new ValidationException(616);
        }else if(signupRequest.getName() !=null && !StringUtils.isBlank(signupRequest.getName().getFirstName()) && (signupRequest.getName().getFirstName().length() < 2 || signupRequest.getName().getFirstName().length() > 70)){
            throw new ValidationException(646);
        }else if(signupRequest.getName() !=null && !StringUtils.isBlank(signupRequest.getName().getLastName()) && (signupRequest.getName().getLastName().length() < 2 || signupRequest.getName().getLastName().length() > 70)){
            throw new ValidationException(647);
        }else if(!StringUtils.isBlank(signupRequest.getDescription()) && signupRequest.getDescription().length() > 200){
            throw new ValidationException(618);
        }else if(StringUtils.isBlank(signupRequest.getEmail())){
            throw new ValidationException(602);
        }else if(!emailValidator.isValid(signupRequest.getEmail())){
            throw new ValidationException(614);
        }else if(!StringUtils.isBlank(signupRequest.getPassword()) && (signupRequest.getPassword().length()< 8  || signupRequest.getPassword().length() > 70)){
            throw new ValidationException(615);
        }

        if(signupRequest.getSignupType() ==  XSignupType.LOCAL){
            signupRequest.setFacebookToken(null);
            signupRequest.setSocialNetworkID(null);
            signupRequest.setFacebookTokenType(null);
        }

        if(signupRequest.getSignupType() == XSignupType.LOCAL){//local signup
            User newUser =userSignupService.signup(signupRequest);

        }else if(signupRequest.getSignupType() == XSignupType.FACEBOOK){

        }

       return  Response.status(Response.Status.CREATED).entity(null).build();
    }
}
