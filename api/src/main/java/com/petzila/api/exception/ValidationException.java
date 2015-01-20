package com.petzila.api.exception;

import com.petzila.api.model.XPetzilaResponse;
import com.petzila.api.model.XResponseType;
import com.petzila.api.utils.ApiUtils;

/**
 * Created by vicente on 16/01/15.
 */
public class ValidationException extends RuntimeException {

    private XPetzilaResponse petzilaResponse;

    public ValidationException(int code) {
        petzilaResponse = new XPetzilaResponse();
        petzilaResponse.setStatus(XResponseType.FAIL);
        petzilaResponse.setMessage(ApiUtils.getError(String.valueOf(code)));
        petzilaResponse.setCode(code);
    }

    public XPetzilaResponse getPetzilaResponse() {
        return petzilaResponse;
    }
}
