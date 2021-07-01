package com.nology.nologer;

public class Student {

	private String firstName;
	private String lastName;
	private int age;
	private String location;
	private String[] interests;
	private String id;

	public Student(String firstName, String lastName, int age, String location, String[] interests, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.location = location;
		this.interests = interests;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}
}
