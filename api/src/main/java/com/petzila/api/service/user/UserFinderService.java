package com.petzila.api.service.user;

import com.petzila.api.domain.User;

public interface UserFinderService {
    User getById(long id);

    User getByEmail(String email);

    boolean existsEmail(String email);
}
