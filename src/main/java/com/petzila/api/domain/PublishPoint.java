package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vicente on 17/01/15.
 */
@Entity
@Table(name = "publish_point", catalog = "petzila", schema = "")
public class PublishPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publish_point_id")
    private Long publishPointId;
    @Basic(optional = false)
    @Column(name = "os")
    private String os;
    @Basic(optional = false)
    @Column(name = "publish_point")
    private String publishPoint;
    @JoinColumn(name = "session_request_id", referencedColumnName = "session_request_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SessionRequest sessionRequestId;

    public PublishPoint() {
    }

    public PublishPoint(Long publishPointId) {
        this.publishPointId = publishPointId;
    }

    public PublishPoint(Long publishPointId, String os, String publishPoint) {
        this.publishPointId = publishPointId;
        this.os = os;
        this.publishPoint = publishPoint;
    }

    public Long getPublishPointId() {
        return publishPointId;
    }

    public void setPublishPointId(Long publishPointId) {
        this.publishPointId = publishPointId;
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

    public SessionRequest getSessionRequestId() {
        return sessionRequestId;
    }

    public void setSessionRequestId(SessionRequest sessionRequestId) {
        this.sessionRequestId = sessionRequestId;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.publishPointId);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (PublishPoint.class.isInstance(obj)) {
            PublishPoint publishPoint = PublishPoint.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.publishPointId, publishPoint.getPublishPointId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

