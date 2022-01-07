package com.bridgelabz.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<Contact> contactBook = new ArrayList<>();
   
   public void addContact() {
		System.out.print("Enter First Name = ");
 	    String FirstName = scanner.next();
 		
 		System.out.print("Enter Last Name = ");
 	    String LastName = scanner.next();
 		
 		System.out.print("Enter Address = ");
	    String Address = scanner.next();
 		
 		System.out.print("Enter City = ");
 	    String City = scanner.next();
 		
 		System.out.print("Enter State = ");
 	    String State = scanner.next();
 		
 		System.out.print("Enter Zip Code = ");
 	    int ZipCode = scanner.nextInt();
 		
 		System.out.print("Enter Phone Number = ");
 	    long PhoneNumber = scanner.nextLong();
 		
 		System.out.print("Enter E-mail = ");
 	    String Email = scanner.next();
	
        Contact contact = new Contact (FirstName , LastName , Address , City , State , ZipCode , PhoneNumber , Email);
 		contactBook.add(contact);
 		
 		System.out.println("Contact added Successfully.");
	}
   
    public void displayContact() {
    	for(Contact person : contactBook) {
    		System.out.println(person.toString());
    	}
    }
}
