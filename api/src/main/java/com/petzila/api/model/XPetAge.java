package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum XPetAge {
    @XmlEnumValue("zero-three")
    ZERO_THREE("zero-three"),
    @XmlEnumValue("three-five")
    THREE_FIVE("three-five"),
    @XmlEnumValue("five-ten")
    FIVE_TEN("five-ten"),
    @XmlEnumValue("ten-fifthteen")
    TEN_FIFTHTEEN("ten-fifthteen"),
    @XmlEnumValue("fifthteen-more")
    FIFTHTEEN_MORE("fifthteen-more");
    private final String value;

    XPetAge(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XPetAge fromValue(String v) {
        for (XPetAge c : XPetAge.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
