package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XNotificationType {
    @XmlEnumValue("like")
    LIKE("like"),
    @XmlEnumValue("comment")
    COMMENT("comment"),
    @XmlEnumValue("follow")
    FOLLOW("follow");
    private final String value;

    XNotificationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XNotificationType fromValue(String v) {
        for (XNotificationType c : XNotificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
