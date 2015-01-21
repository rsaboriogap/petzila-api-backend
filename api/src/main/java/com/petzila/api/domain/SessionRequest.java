package com.petzila.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "session_request")
public class SessionRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "session_request_id")
    private long id;
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
    @Column(name = "is_ready")
    private boolean ready;
    @Basic(optional = false)
    @Column(name = "is_processed")
    private boolean processed;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "need_process")
    private boolean needProcess;
    @Basic(optional = false)
    @Column(name = "is_invalid")
    private boolean invalid;
    @JoinColumn(name = "petzi_connect_id", referencedColumnName = "petzi_connect_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PetziConnect petziConnect;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PetziConnect getPetziConnect() {
        return petziConnect;
    }

    public void setPetziConnect(PetziConnect petziConnect) {
        this.petziConnect = petziConnect;
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
        if (SessionRequest.class.isInstance(obj)) {
            SessionRequest sessionRequest = SessionRequest.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, sessionRequest.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
