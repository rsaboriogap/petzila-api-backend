package com.petzila.api.utils;

public enum ErrorCode {
    VALIDATION_ERROR_SIGN_UP_TYPE(612);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
