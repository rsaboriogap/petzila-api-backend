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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "petzi_connect", catalog = "petzila", schema = "")
public class PetziConnect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "petzi_connect_id")
    private Long petziConnectId;
    @Basic(optional = false)
    @Column(name = "mac_address")
    private String macAddress;
    @Column(name = "petzi_ip")
    private String petziIp;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "default")
    private boolean default1;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public PetziConnect() {
    }

    public PetziConnect(Long petziConnectId) {
        this.petziConnectId = petziConnectId;
    }

    public PetziConnect(Long petziConnectId, String macAddress, boolean default1) {
        this.petziConnectId = petziConnectId;
        this.macAddress = macAddress;
        this.default1 = default1;
    }

    public Long getPetziConnectId() {
        return petziConnectId;
    }

    public void setPetziConnectId(Long petziConnectId) {
        this.petziConnectId = petziConnectId;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getPetziIp() {
        return petziIp;
    }

    public void setPetziIp(String petziIp) {
        this.petziIp = petziIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDefault1() {
        return default1;
    }

    public void setDefault1(boolean default1) {
        this.default1 = default1;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.petziConnectId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (PetziConnect.class.isInstance(obj)) {
            PetziConnect petziConnect= PetziConnect.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.petziConnectId, petziConnect.getPetziConnectId());
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
