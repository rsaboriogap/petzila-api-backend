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
@Table(name = "pet_follow", catalog = "petzila", schema = "")
public class PetFollow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pet_follow_id")
    private Long petFollowId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pet petId;

    public PetFollow() {
    }

    public PetFollow(Long petFollowId) {
        this.petFollowId = petFollowId;
    }

    public Long getPetFollowId() {
        return petFollowId;
    }

    public void setPetFollowId(Long petFollowId) {
        this.petFollowId = petFollowId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.petFollowId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (PetFollow.class.isInstance(obj)) {
            PetFollow petFollow= PetFollow.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.petFollowId, petFollow.getPetFollowId());
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
