//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.16 at 04:19:06 PM CST 
//


package com.petzila.api.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XFacebookTokenType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="XFacebookTokenType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="shortTerm"/>
 *     &lt;enumeration value="longTerm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "XFacebookTokenType")
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
        for (XFacebookTokenType c: XFacebookTokenType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
