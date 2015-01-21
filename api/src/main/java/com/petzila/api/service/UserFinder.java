package com.petzila.api.service;

import com.petzila.api.domain.User;

public interface UserFinder {
    User find(long id);

    User get(long id);

    User findByEmail(String email);

    User getByEmail(String email);
}
