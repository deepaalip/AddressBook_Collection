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

	@Override
	public String toString() {
		return " AddressBookList- AddressBookName = " + AddressBookName + "  " + "Contacts- " + contact;
	}

}
