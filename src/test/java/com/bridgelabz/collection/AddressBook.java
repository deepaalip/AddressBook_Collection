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
    
    public void editContact() {
    	System.out.println("Enter firstName to edit contact");
    	String Name = scanner.next();
    	for(Contact person : contactBook) {
    		if(Name.equals(person.firstName)) {
    			System.out.println("Select Option to Update :" + "1. FirstName " + "2. LastName " + "3. Address " + "4.City " + "5.State "
						 + "6. ZipCode " + "7. PhoneNumber "+ "8. Email ");
    			int option = scanner.nextInt();
    			switch(option) {
    			case 1:
					System.out.println("Enter new FirstName");
					String newFirstName = scanner.next();
					person.setFirstName(newFirstName);
					System.out.println("Name Updated");
					break;

				case 2:
					System.out.println("Enter new Last Name");
					String newLastName = scanner.next();
					person.setLastName(newLastName);
					System.out.println("Name Updated");
					break;

				case 3:
					System.out.println("Enter New Address");
					String newAddress = scanner.next();
					person.setAddress(newAddress);
					System.out.println("Address Updated");
					break;

				case 4:
					System.out.println("Enter Updating city");
					String newCity = scanner.next();
					person.setCity(newCity);
					System.out.println("City Location Updated");
					break;
					

				case 5:
					System.out.println("Enter new State name");
					String newState = scanner.next();
					person.setState(newState);
					System.out.println("State location updated ");
					break;

				case 6:
					System.out.println("Enter new ZipCode");
					int newzip = scanner.nextInt();
					person.setZipCode(newzip);
					System.out.println("ZipCode Updated");
					break;

				case 7:
					System.out.println("Update PhoneNumber");
					int newphone = scanner.nextInt();
					person.setPhoneNumber(newphone);
					System.out.println("PhoneNumber Update");
					break;

				case 8:
					System.out.println("Update Email");
					String newMail = scanner.next();
					person.setEmail(newMail);
					System.out.println("Mail updated");
					break;

				default:
					System.out.println("Choose a number for Credential to 1-8");
				}
			} else {
				continue;
			}
    			
    		
    	}
    }
                 public void deleteContact() {
                	 System.out.println("Enter  linked Email to Delete the Contact");
             		String DeleteContact = scanner.next();

             		for (int i = 0; i < contactBook.size(); i++) {
             			String CheckingMail = contactBook.get(i).getEmail();

             			if (DeleteContact.equals(CheckingMail)) {
             				contactBook.remove(i);
             				System.out.println("Contact Deleted Suucessfully");
             				break;

             			} else {
             				continue;
             			}
             		}
                 }
                 
}
