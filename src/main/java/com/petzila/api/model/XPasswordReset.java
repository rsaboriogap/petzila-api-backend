//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.15 at 04:04:06 PM CST 
//


package com.petzila.api.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reset_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="new_password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "resetCode",
        "email",
        "newPassword"
})
@XmlRootElement(name = "XPasswordReset")
public class XPasswordReset {

    @XmlElement(name = "reset_code", required = true)
    protected String resetCode;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(name = "new_password", required = true)
    protected String newPassword;

    /**
     * Gets the value of the resetCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResetCode() {
        return resetCode;
    }

    /**
     * Sets the value of the resetCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResetCode(String value) {
        this.resetCode = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the newPassword property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the value of the newPassword property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNewPassword(String value) {
        this.newPassword = value;
    }

}