package com.petzila.api.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XResponse {
    XStatusType status = XStatusType.SUCCESS;

    public XStatusType getStatus() {
        return status;
    }

    public void setStatus(XStatusType status) {
        this.status = status;
    }
}
