package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "petzi_connect")
public class PetziConnect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "petzi_connect_id")
    private long id;
    @Basic(optional = false)
    @Column(name = "mac_address")
    private String macAddress;
    @Column(name = "petzi_ip")
    private String petziIp;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "default")
    private boolean isDefault;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (PetziConnect.class.isInstance(obj)) {
            PetziConnect petziConnect = PetziConnect.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, petziConnect.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
