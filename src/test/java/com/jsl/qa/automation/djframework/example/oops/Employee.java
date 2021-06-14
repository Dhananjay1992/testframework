package com.jsl.qa.automation.djframework.example.oops;

public class Employee implements EmployeeInterface {
    private static long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private long employeeSalary;
    private EmployeeDesignation designation;
    private EmployeePersonalDetails employeePersonalDetails;
    private  CompanyDepartments employeeDepartments;

    public Employee(String employeeFirstName, String employeeLastName, long employeeSalary, EmployeePersonalDetails employeePersonalDetails, EmployeeDesignation designation) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeSalary = employeeSalary;
        this.employeePersonalDetails = employeePersonalDetails;
        this.designation = designation;
    }

    public static long getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(long employeeId) {
        Employee.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public EmployeePersonalDetails getEmployeePersonalDetails() {
        return employeePersonalDetails;
    }

    public void setEmployeePersonalDetails(EmployeePersonalDetails employeePersonalDetails) {
        this.employeePersonalDetails = employeePersonalDetails;
    }

    public EmployeeDesignation getDesignation() {
        return designation;
    }

    public void setDesignation(EmployeeDesignation designation) {
        this.designation = designation;
    }

}
