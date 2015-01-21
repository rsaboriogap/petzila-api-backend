package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id")
    private long id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Post post;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        if (Comment.class.isInstance(obj)) {
            Comment comment = Comment.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, comment.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
