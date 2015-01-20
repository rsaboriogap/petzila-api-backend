package com.petzila.api.service.user;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignUp;

public interface UserSignUpService {
    User signUp(XSignUp signUp);
}
