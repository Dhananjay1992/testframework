package com.jsl.qa.automation.djframework.example.oops;

public class EmployeeContactDetails {
    private String mobileNumberPersonal;
    private String officeNumber;
    private String emergencyFamilyNumber;

    public EmployeeContactDetails(String mobileNumberPersonal, String officeNumber, String emergencyFamilyNumber) {
        this.mobileNumberPersonal = mobileNumberPersonal;
        this.officeNumber = officeNumber;
        this.emergencyFamilyNumber = emergencyFamilyNumber;
    }

    public String getMobileNumberPersonal() {
        return mobileNumberPersonal;
    }

    public void setMobileNumberPersonal(String mobileNumberPersonal) {
        this.mobileNumberPersonal = mobileNumberPersonal;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getEmergencyFamilyNumber() {
        return emergencyFamilyNumber;
    }

    public void setEmergencyFamilyNumber(String emergencyFamilyNumber) {
        this.emergencyFamilyNumber = emergencyFamilyNumber;
    }
}
