package com.jsl.qa.automation.djframework.example.oops;

public class EmployeePersonalDetails implements EmployeeInterface {
    private Address homeAddress;
    private Address officeAddress;
    private EmployeeContactDetails employeeContactDetails;
    private EmployeeGender employeeGender;
    private String dob;
    private byte age;

    public EmployeePersonalDetails(Address homeAddress, Address officeAddress, EmployeeContactDetails employeeContactDetails, EmployeeGender employeeGender, String dob) {
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
        this.employeeContactDetails = employeeContactDetails;
        this.employeeGender = employeeGender;
        this.dob = dob;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public EmployeeContactDetails getEmployeeContactDetails() {
        return employeeContactDetails;
    }

    public void setEmployeeContactDetails(EmployeeContactDetails employeeContactDetails) {
        this.employeeContactDetails = employeeContactDetails;
    }

    public EmployeeGender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(EmployeeGender employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

	static class EmployeeAddress {
    	private Address homeAddress;
    	private Address officeAddress = new Address("office", "offcei 2", "line3", "mah", "india");
    	private int age;
	}
}
