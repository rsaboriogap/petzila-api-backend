//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.16 at 11:46:56 AM CST 
//


package com.petzila.api.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.petzila.api.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.petzila.api.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XSignupRequest }
     * 
     */
    public XSignupRequest createXSignupRequest() {
        return new XSignupRequest();
    }

    /**
     * Create an instance of {@link XName }
     * 
     */
    public XName createXName() {
        return new XName();
    }

    /**
     * Create an instance of {@link XLocation }
     * 
     */
    public XLocation createXLocation() {
        return new XLocation();
    }

    /**
     * Create an instance of {@link XPetzilaResponse }
     * 
     */
    public XPetzilaResponse createXPetzilaResponse() {
        return new XPetzilaResponse();
    }

}