package com.petzila.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rsaborio on 16/12/14.
 */
public class LoginResponse {
    @JsonProperty
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
