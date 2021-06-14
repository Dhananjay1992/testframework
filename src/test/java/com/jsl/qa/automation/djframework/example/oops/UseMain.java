package com.jsl.qa.automation.djframework.example.oops;

public class UseMain {


	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Without object creation" +  Student.getId());
		Student defaultObject = new Student();
		System.out.println("----Printing defaultObject----");
		System.out.println(defaultObject.getName());
		System.out.println(defaultObject.getAge());
		System.out.println(defaultObject.getStandard());
		System.out.println(Student.getId());
		Student dhananjay = new Student("dhananjay",(byte) 29,(byte)11);
		System.out.println("----Printing Student----");
		System.out.println(dhananjay.getName());
		System.out.println(dhananjay.getAge());
		System.out.println(dhananjay.getStandard());
		System.out.println(Student.getId());
		Student gayatri = new Student("Gayatri",(byte) 27,(byte)9);
		System.out.println("----Printing Student----");
		System.out.println(gayatri.getName());
		System.out.println(gayatri.getAge());
		System.out.println(gayatri.getStandard());
		System.out.println(Student.getId());
		Address homeAddress = new Address("line1", "line2", "line3", "mah", "india");
		Address officeAddress=new Address("office", "offcei 2", "line3", "mah", "india");
		EmployeeContactDetails employeeContactDetails =new EmployeeContactDetails("1","2","3");;
		EmployeePersonalDetails employeePersonalDetails =  new EmployeePersonalDetails(homeAddress,officeAddress,employeeContactDetails, EmployeeInterface.EmployeeGender.MALE,"25-Aug-1992");
		new EmployeePersonalDetails.EmployeeAddress();
		Employee dj = new Employee("Dhananjay", "Joshi",150000,employeePersonalDetails, EmployeeInterface.EmployeeDesignation.DEV);

	}
	public static void main(String[] args1, int a) {

	}
}
