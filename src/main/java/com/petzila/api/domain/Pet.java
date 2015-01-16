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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pet", catalog = "petzila", schema = "")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pet_id")
    private Long petId;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "age")
    private String age;
    @Basic(optional = false)
    @Column(name = "species")
    private String species;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "description")
    private String description;
    @Column(name = "breed")
    private String breed;
    @Column(name = "other")
    private String other;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Column(name = "food")
    private String food;
    @Column(name = "website")
    private String website;
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;

    public Pet() {
    }

    public Pet(Long petId) {
        this.petId = petId;
    }

    public Pet(Long petId, String age, String species, String size, String gender, Date createdAt) {
        this.petId = petId;
        this.age = age;
        this.species = species;
        this.size = size;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.petId);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (Pet.class.isInstance(obj)) {
            Pet pet= Pet.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.petId, pet.getPetId());
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
