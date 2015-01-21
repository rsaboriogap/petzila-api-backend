package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publish_point")
public class PublishPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publish_point_id")
    private long id;
    @Basic(optional = false)
    @Column(name = "os")
    private String os;
    @Basic(optional = false)
    @Column(name = "publish_point")
    private String publishPoint;
    @JoinColumn(name = "session_request_id", referencedColumnName = "session_request_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SessionRequest sessionRequest;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPublishPoint() {
        return publishPoint;
    }

    public void setPublishPoint(String publishPoint) {
        this.publishPoint = publishPoint;
    }

    public SessionRequest getSessionRequest() {
        return sessionRequest;
    }

    public void setSessionRequest(SessionRequest sessionRequest) {
        this.sessionRequest = sessionRequest;
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
        if (PublishPoint.class.isInstance(obj)) {
            PublishPoint publishPoint = PublishPoint.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, publishPoint.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

