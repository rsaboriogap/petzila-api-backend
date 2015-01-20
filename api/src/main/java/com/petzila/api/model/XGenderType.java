package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XGenderType {
    @XmlEnumValue("male")
    MALE("male"),
    @XmlEnumValue("female")
    FEMALE("female");
    private final String value;

    XGenderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XGenderType fromValue(String v) {
        for (XGenderType c : XGenderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
