package com.petzila.api.service.user;

import com.petzila.api.domain.User;
import com.petzila.api.model.XSignupRequest;

/**
 * Created by vicente on 16/01/15.
 */
public interface UserFinderService {
    User getById(long id);
    User getByEmail(String email);
    Boolean existsEmail(String email);
}
