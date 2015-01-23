package com.petzila.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XLogin {
    private String email;
    private String password;
    private String loginType;
    private String socialNetworkID;
    private String facebookToken;
    private String facebookTokenType;

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

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
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

    public String getFacebookTokenType() {
        return facebookTokenType;
    }

    public void setFacebookTokenType(String facebookTokenType) {
        this.facebookTokenType = facebookTokenType;
    }
}
