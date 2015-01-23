package com.petzila.api.service;

import com.petzila.api.domain.User;
import com.petzila.api.model.XLogin;

public interface UserLoginService {
    User login(XLogin login);
}
