package com.petzila.api.model.response;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class XError {
    public static class XData {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("message", message)
                    .toString();
        }
    }

    private int code;
    private XStatusType status;
    private XData data = new XData();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public XStatusType getStatus() {
        return status;
    }

    public void setStatus(XStatusType status) {
        this.status = status;
    }

    public XData getData() {
        return data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("code", code)
                .add("data", data)
                .toString();
    }
}
