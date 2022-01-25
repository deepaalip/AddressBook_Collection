package com.bridgelabz.collection;

public class Contact {
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public int zipCode;
	public long phoneNumber;
	public String email;

		
	
	public Contact(String firstName,String lastName,String address,String city,String state,int zipCode,long phoneNumber,String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName= " + lastName + ", address=" + address +", city=" + city +", state=" + state +", zipCode="
				+ zipCode +", phoneNumber=" + phoneNumber + ",email=" + email + "]";
	}
	
	
  public String getFirstName() {
	  return firstName;
  }
  public void setFirstName(String FirstName) {
	  FirstName = firstName;
  }
  public String getLastName() {
	  return lastName;  
  }
  public void setLastName(String LastName) {
	  LastName = lastName;
  }
  public String getAddress() {
	  return address;
  }
  public void setAddress(String Address) {
	  Address = address;
  }
  public String getCity() {
	  return city;
  }
  public void setCity(String City) {
	  City = city;
  }
  public String getState() {
	  return state;
  }
  public void setState(String State) {
	  State = state;
  }
  public int getZipCode() {
	  return zipCode;
  }
  public void setZipCode(int ZipCode) {
	  ZipCode = zipCode;
  }
  public long getPhoneNumber() {
	  return phoneNumber;
  }
  public void setPhoneNumber(long PhoneNumber) {
	  PhoneNumber = phoneNumber;
  }
  public String getEmail() {
	  return email;
  }
  public void setEmail(String Email) {
	 Email = email;  
  }
}
