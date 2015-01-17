package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author vicente
 */
@Entity
@Table(name = "session_request", catalog = "petzila", schema = "")
@NamedQueries({
        @NamedQuery(name = "SessionRequest.findAll", query = "SELECT s FROM SessionRequest s")})
public class SessionRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "session_request_id")
    private Long sessionRequestId;
    @Column(name = "ms_nonce")
    private String msNonce;
    @Column(name = "audio_port")
    private String audioPort;
    @Column(name = "session_server_ip")
    private String sessionServerIp;
    @Column(name = "session_server_password")
    private String sessionServerPassword;
    @Column(name = "session_server_nonce")
    private String sessionServerNonce;
    @Basic(optional = false)
    @Column(name = "ready")
    private boolean ready;
    @Basic(optional = false)
    @Column(name = "processed")
    private boolean processed;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "need_process")
    private boolean needProcess;
    @Basic(optional = false)
    @Column(name = "invalid")
    private boolean invalid;
    @JoinColumn(name = "petzi_connect_id", referencedColumnName = "petzi_connect_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PetziConnect petziConnectId;

    public SessionRequest() {
    }

    public SessionRequest(Long sessionRequestId) {
        this.sessionRequestId = sessionRequestId;
    }

    public SessionRequest(Long sessionRequestId, boolean ready, boolean processed, boolean needProcess, boolean invalid) {
        this.sessionRequestId = sessionRequestId;
        this.ready = ready;
        this.processed = processed;
        this.needProcess = needProcess;
        this.invalid = invalid;
    }

    public Long getSessionRequestId() {
        return sessionRequestId;
    }

    public void setSessionRequestId(Long sessionRequestId) {
        this.sessionRequestId = sessionRequestId;
    }

    public String getMsNonce() {
        return msNonce;
    }

    public void setMsNonce(String msNonce) {
        this.msNonce = msNonce;
    }

    public String getAudioPort() {
        return audioPort;
    }

    public void setAudioPort(String audioPort) {
        this.audioPort = audioPort;
    }

    public String getSessionServerIp() {
        return sessionServerIp;
    }

    public void setSessionServerIp(String sessionServerIp) {
        this.sessionServerIp = sessionServerIp;
    }

    public String getSessionServerPassword() {
        return sessionServerPassword;
    }

    public void setSessionServerPassword(String sessionServerPassword) {
        this.sessionServerPassword = sessionServerPassword;
    }

    public String getSessionServerNonce() {
        return sessionServerNonce;
    }

    public void setSessionServerNonce(String sessionServerNonce) {
        this.sessionServerNonce = sessionServerNonce;
    }

    public boolean getReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean getProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean getNeedProcess() {
        return needProcess;
    }

    public void setNeedProcess(boolean needProcess) {
        this.needProcess = needProcess;
    }

    public boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public PetziConnect getPetziConnectId() {
        return petziConnectId;
    }

    public void setPetziConnectId(PetziConnect petziConnectId) {
        this.petziConnectId = petziConnectId;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.sessionRequestId);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (SessionRequest.class.isInstance(obj)) {
            SessionRequest sessionRequest = SessionRequest.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.sessionRequestId, sessionRequest.getSessionRequestId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
