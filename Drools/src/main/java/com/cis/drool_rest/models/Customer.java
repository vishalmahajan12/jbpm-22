package com.cis.drool_rest.models;

public class Customer {

	private String name;
	private double salary;
	private double experience;
	
	public Customer(String name, double salary, double experience) {
		super();
		this.name = name;
		this.salary = salary;
		this.experience = experience;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
	}
	
	
	
	
}
