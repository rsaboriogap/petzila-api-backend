package com.petzila.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pidentity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "auth_token")
})
public class Identity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identity_id")
    private long id;
    @Version
    @Column(name = "version")
    private long version;
    @NotNull
    @Size(max = 200)
    @Column(name = "auth_token")
    private String authToken;
    @NotNull
    @Column(name = "accessed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessedDate;
    @NotNull
    @JoinColumn(name = "owner_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getAccessedDate() {
        return accessedDate;
    }

    public void setAccessedDate(Date accessedDate) {
        this.accessedDate = accessedDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Identity && ((Identity) obj).getId() == getId();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" + id + "]";
    }
}