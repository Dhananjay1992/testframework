package com.jsl.qa.automation.djframework.example.oops;

public class Student {
	private String name;
	private byte age;
	private static int id=25;
	private byte standard;
	{
		int id = 51;
	}
	public Student(){
		System.out.println("Student initialized");
	}
	static{
		System.out.println(id);
	}
	static {
//		id=10;
	}
	static {
		id+=10;
	}
	public Student(String name, byte age, byte standard) {
		this.name = name;
		this.age = age;
		this.standard = standard;
		id++;
	}
	public Student(String name, byte age, byte standard, int idM) {
		this.name = name;
		this.age = age;
		this.standard = standard;
		id=idM;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public static int getId() {

		return id;
	}

	public static void setId(int id) {
		Student.id = id;
	}

	public byte getStandard() {
		return standard;
	}

	public void setStandard(byte standard) {
		this.standard = standard;
	}

}
