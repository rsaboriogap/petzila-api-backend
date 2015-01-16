/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "user", catalog = "petzila", schema = "")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "activation_key")
    private String activationKey;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "is_founder")
    private boolean isFounder;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "signup_type")
    private String signupType;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private Integer zipCode;
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Column(name = "temporal_password")
    private String temporalPassword;
    @Column(name = "social_network_id")
    private String socialNetworkId;
    @Column(name = "temporal_password_expiration")
    @Temporal(TemporalType.DATE)
    private Date temporalPasswordExpiration;
    @Column(name = "facebook_token")
    private String facebookToken;
    @Column(name = "merge_type")
    private String mergeType;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;


    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, boolean active, boolean isFounder, String username, String password, String salt, String signupType, String firstName, String lastName, String email, Date createdAt) {
        this.userId = userId;
        this.active = active;
        this.isFounder = isFounder;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.signupType = signupType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getIsFounder() {
        return isFounder;
    }

    public void setIsFounder(boolean isFounder) {
        this.isFounder = isFounder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSignupType() {
        return signupType;
    }

    public void setSignupType(String signupType) {
        this.signupType = signupType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTemporalPassword() {
        return temporalPassword;
    }

    public void setTemporalPassword(String temporalPassword) {
        this.temporalPassword = temporalPassword;
    }

    public String getSocialNetworkId() {
        return socialNetworkId;
    }

    public void setSocialNetworkId(String socialNetworkId) {
        this.socialNetworkId = socialNetworkId;
    }

    public Date getTemporalPasswordExpiration() {
        return temporalPasswordExpiration;
    }

    public void setTemporalPasswordExpiration(Date temporalPasswordExpiration) {
        this.temporalPasswordExpiration = temporalPasswordExpiration;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getMergeType() {
        return mergeType;
    }

    public void setMergeType(String mergeType) {
        this.mergeType = mergeType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.userId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (User.class.isInstance(obj)) {
            User user= User.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.userId, user.getUserId());
            equals = eb.isEquals();
        }
        return equals;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
