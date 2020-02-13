package com.itwill.bean;

public class Student {
	private int no;
	private String name;
	private int age;
	private Car car;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int no, String name, int age, Car car) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
