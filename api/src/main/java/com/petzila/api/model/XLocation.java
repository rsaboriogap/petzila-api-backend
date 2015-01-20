package com.petzila.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XLocation {
    private String country;
    private String city;
    private int zipCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
