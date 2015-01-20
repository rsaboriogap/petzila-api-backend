package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XFacebookTokenType {
    @XmlEnumValue("shortTerm")
    SHORT_TERM("shortTerm"),
    @XmlEnumValue("longTerm")
    LONG_TERM("longTerm");
    private final String value;

    XFacebookTokenType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XFacebookTokenType fromValue(String v) {
        for (XFacebookTokenType c : XFacebookTokenType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
