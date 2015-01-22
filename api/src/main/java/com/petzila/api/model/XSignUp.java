package com.petzila.api.model;

import com.petzila.api.validator.ValidXSignUpType;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XSignUp {
    private String email;
    private String password;
    @NotNull
    private String username;
    private String profilePicture;
    private XResourceType resourceType;
    private String description;
    private XName name = new XName();
    private XLocation location = new XLocation();
    @ValidXSignUpType
    private XSignUpType signupType = XSignUpType.LOCAL;
    private String socialNetworkID;
    private String facebookToken;
    private XFacebookTokenType facebookTokenType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public XResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(XResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public XName getName() {
        return name;
    }

    public void setName(XName name) {
        this.name = name;
    }

    public XLocation getLocation() {
        return location;
    }

    public void setLocation(XLocation location) {
        this.location = location;
    }

    public XSignUpType getSignupType() {
        return signupType;
    }

    public void setSignupType(XSignUpType signupType) {
        this.signupType = signupType;
    }

    public String getSocialNetworkID() {
        return socialNetworkID;
    }

    public void setSocialNetworkID(String socialNetworkID) {
        this.socialNetworkID = socialNetworkID;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public XFacebookTokenType getFacebookTokenType() {
        return facebookTokenType;
    }

    public void setFacebookTokenType(XFacebookTokenType facebookTokenType) {
        this.facebookTokenType = facebookTokenType;
    }
}
