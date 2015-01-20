package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XSignUpType {
    @XmlEnumValue("local")
    LOCAL("local"),
    @XmlEnumValue("facebook")
    FACEBOOK("facebook");
    private final String value;

    XSignUpType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XSignUpType fromValue(String v) {
        for (XSignUpType c : XSignUpType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
