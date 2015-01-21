package com.petzila.api.utils;

public enum ErrorCode {
    VALIDATION_ERROR_SIGN_UP_TYPE(612),
    ERROR_0(0), //@TODO not found exception ??
    ERROR_614(614),
    ERROR_619(619);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
