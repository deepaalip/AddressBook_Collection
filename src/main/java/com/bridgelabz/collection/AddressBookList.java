package com.bridgelabz.collection;

import java.util.ArrayList;

public class AddressBookList {
	String AddressBookName;
	ArrayList<Contact> contact;


	public AddressBookList(String AddressBookName) {
		this.AddressBookName = AddressBookName;
		this.contact = new ArrayList<Contact>();

	}

	public String getAddressBookName() {
		return AddressBookName;
	}

	public void setAddressBookName(String AddressBookName) {
		this.AddressBookName = AddressBookName;
	}
	public ArrayList<Contact> getContact() {
		return contact;
	}

	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return " AddressBookList- AddressBookName = " + AddressBookName + "  " + "Contacts- " + contact;
	}

}
