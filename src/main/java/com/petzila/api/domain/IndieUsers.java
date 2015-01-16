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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "IndieUsers", catalog = "petzila", schema = "")
public class IndieUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "indie_user_id")
    private Long indieUserId;
    @Column(name = "email")
    private String email;

    public IndieUsers() {
    }

    public IndieUsers(Long indieUserId) {
        this.indieUserId = indieUserId;
    }

    public Long getIndieUserId() {
        return indieUserId;
    }

    public void setIndieUserId(Long indieUserId) {
        this.indieUserId = indieUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.indieUserId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (IndieUsers.class.isInstance(obj)) {
            IndieUsers indieUsers= IndieUsers.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.indieUserId, indieUsers.getIndieUserId());
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
