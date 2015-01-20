package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XPetSize {
    @XmlEnumValue("small")
    SMALL("small"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("large")
    LARGE("large");
    private final String value;

    XPetSize(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XPetSize fromValue(String v) {
        for (XPetSize c : XPetSize.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
