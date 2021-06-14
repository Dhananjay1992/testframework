package com.jsl.qa.automation.djframework.example.oops;

public class Address {
    private String addressLineOne;
    private String addressLineTwo;
    private String street;
    private String state;
    private String country;

    public Address(String addressLineOne, String addressLineTwo, String street, String state, String country) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.street = street;
        this.state = state;
        this.country = country;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
