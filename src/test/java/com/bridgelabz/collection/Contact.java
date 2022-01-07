package com.bridgelabz.collection;

public class Contact {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zipCode;
	int phoneNumber;
	String email;
	
	public Contact(String firstName,String lastName,String address,String city,String state,int zipCode,int phoneNumber,String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName= " + lastName + ", address=" + address +", city=" + city +", state=" + state +", zipCode="
				+ zipCode +", phoneNumber=" + phoneNumber + ",email=" + email + "]";
	}
}
