package com.ykko.entity;

public class Request {
	
	private String firstName;
	private String lastName;
	private String cellPhoneNumber;
	
	public Request() {}
	public Request(String firstName, String lastName, String cellPhoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhoneNumber = cellPhoneNumber;
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
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String toString() {
		return "FirstName: " + this.firstName + ",LastName: " + this.lastName + ",CellPhoneNumber:" + this.cellPhoneNumber; 
	}
}
