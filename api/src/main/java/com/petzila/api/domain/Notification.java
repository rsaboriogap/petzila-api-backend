package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notification", catalog = "petzila", schema = "")
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notification_id")
    private long id;
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column(name = "type")
    private NotificationType type = NotificationType.COMMENT;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "is_pending")
    private boolean isPending;
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pet pet;
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Post post;
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User createdBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean isPending) {
        this.isPending = isPending;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet petId) {
        this.pet = petId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post postId) {
        this.post = postId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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
        if (Notification.class.isInstance(obj)) {
            Notification notification = Notification.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, notification.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
