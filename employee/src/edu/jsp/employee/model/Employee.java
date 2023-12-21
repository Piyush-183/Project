package edu.jsp.employee.model;

public class Employee {

	private int id;
	private String name;
	private Double sal;
	private long contact;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public Employee(int id, String name, Double sal, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.contact = contact;
	}
	public Employee() {
		super();
	}
	
}
