package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_id")
    private long id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "content_url")
    private String contentUrl;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pet pet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
        if (Post.class.isInstance(obj)) {
            Post post = Post.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, post.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
