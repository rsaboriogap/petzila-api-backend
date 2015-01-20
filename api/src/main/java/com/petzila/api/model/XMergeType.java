package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XMergeType {
    @XmlEnumValue("local")
    LOCAL("local"),
    @XmlEnumValue("facebook")
    FACEBOOK("facebook");
    private final String value;

    XMergeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XMergeType fromValue(String v) {
        for (XMergeType c : XMergeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
