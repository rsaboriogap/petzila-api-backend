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
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "device", catalog = "petzila", schema = "")
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "device_id")
    private Long deviceId;
    @Basic(optional = false)
    @Column(name = "os")
    private String os;
    @Basic(optional = false)
    @Column(name = "key")
    private String key;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public Device() {
    }

    public Device(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Device(Long deviceId, String os, String key) {
        this.deviceId = deviceId;
        this.os = os;
        this.key = key;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        hcb.append(this.deviceId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (Device.class.isInstance(obj)) {
            Device device= Device.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.deviceId, device.getDeviceId());
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
