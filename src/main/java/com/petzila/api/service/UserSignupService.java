package com.petzila.api.service;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignupRequest;

/**
 * Created by vicente on 16/01/15.
 */
public interface UserSignupService {
    User signup(XSignupRequest signupRequest);
}
