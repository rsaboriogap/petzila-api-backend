package com.petzila.api.service.user;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignUp;

public interface UserSignupService {
    User signup(XSignUp signUp);
}
