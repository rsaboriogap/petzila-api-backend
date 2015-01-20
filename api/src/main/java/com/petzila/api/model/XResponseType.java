package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XResponseType {
    @XmlEnumValue("Fail")
    FAIL("Fail"),
    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("Error")
    ERROR("Error");
    private final String value;

    XResponseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XResponseType fromValue(String v) {
        for (XResponseType c : XResponseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
