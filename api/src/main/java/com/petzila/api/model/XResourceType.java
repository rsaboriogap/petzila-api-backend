package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XResourceType {
    @XmlEnumValue("image/gif")
    IMAGE_GIF("image/gif"),
    @XmlEnumValue("image/jpeg")
    IMAGE_JPEG("image/jpeg"),
    @XmlEnumValue("image/png")
    IMAGE_PNG("image/png");
    private final String value;

    XResourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XResourceType fromValue(String v) {
        for (XResourceType c : XResourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
