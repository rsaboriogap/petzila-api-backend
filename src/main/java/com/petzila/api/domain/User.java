package com.petzila.api.domain;

import com.petzila.api.model.XMergeType;
import com.petzila.api.model.XSignupType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user", catalog = "petzila", schema = "")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private long id;
    @Column(name = "activation_key")
    private String activationKey;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
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
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column(name = "signup_type")
    private XSignupType signupType=XSignupType.LOCAL;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "temporal_password")
    private String temporalPassword;
    @Column(name = "social_network_id")
    private String socialNetworkId;
    @Column(name = "temporal_password_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temporalPasswordExpiration;
    @Column(name = "facebook_token")
    private String facebookToken;
    @Enumerated(EnumType.STRING)
    @Column(name = "merge_type")
    private XMergeType mergeType = XMergeType.LOCAL;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isFounder() {
        return isFounder;
    }

    public void setFounder(boolean isFounder) {
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

    public XSignupType getSignupType() {
        return signupType;
    }

    public void setSignupType(XSignupType signupType) {
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

    public XMergeType getMergeType() {
        return mergeType;
    }

    public void setMergeType(XMergeType mergeType) {
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
        hcb.append(this.id);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (User.class.isInstance(obj)) {
            User user = User.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, user.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
