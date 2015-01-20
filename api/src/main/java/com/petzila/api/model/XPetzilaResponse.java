package com.petzila.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XPetzilaResponse {
    private XResponseType status;
    private String message;
    private int code;
    private Object data;

    public XResponseType getStatus() {
        return status;
    }

    public void setStatus(XResponseType status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
