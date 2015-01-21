package com.petzila.api.model.response;

public enum XStatusType {
    SUCCESS("Success"),
    FAIL("Fail"),
    ERROR("Error");

    private String status;

    XStatusType(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
