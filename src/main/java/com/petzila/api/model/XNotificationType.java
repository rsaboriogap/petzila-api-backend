//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.20 at 01:10:31 PM CST 
//


package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XNotificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="XNotificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="like"/>
 *     &lt;enumeration value="comment"/>
 *     &lt;enumeration value="follow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "XNotificationType")
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
        for (XNotificationType c: XNotificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
