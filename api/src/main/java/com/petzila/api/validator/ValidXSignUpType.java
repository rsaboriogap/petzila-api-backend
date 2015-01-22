package com.petzila.api.validator;

import com.petzila.api.util.ErrorCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = XSignUpTypeValidator.class)
@Documented
public @interface ValidXSignUpType {
    String message() default "{com.petzila.api.validation.constraints.ValidXSignUpType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ErrorCode code() default ErrorCode.VALIDATION_ERROR_SIGN_UP_TYPE;

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidXSignUpType[] value();
    }
}
