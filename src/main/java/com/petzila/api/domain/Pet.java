package com.petzila.api.domain;

import com.petzila.api.model.XGenderType;
import com.petzila.api.model.XPetAge;
import com.petzila.api.model.XPetSize;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pet", catalog = "petzila", schema = "")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pet_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column(name = "age")
    private XPetAge age=XPetAge.ZERO_THREE;
    @Basic(optional = false)
    @Column(name = "species")
    private String species;
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column(name = "size")
    private XPetSize size =XPetSize.SMALL;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "description")
    private String description;
    @Column(name = "breed")
    private String breed;
    @Column(name = "other")
    private String other;
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column(name = "gender")
    private XGenderType gender = XGenderType.MALE;
    @Column(name = "food")
    private String food;
    @Column(name = "website")
    private String website;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public XPetAge getAge() {
        return age;
    }

    public void setAge(XPetAge age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public XPetSize getSize() {
        return size;
    }

    public void setSize(XPetSize size) {
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

    public XGenderType getGender() {
        return gender;
    }

    public void setGender(XGenderType gender) {
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
        hcb.append(this.id);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (Pet.class.isInstance(obj)) {
            Pet pet = Pet.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, pet.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
