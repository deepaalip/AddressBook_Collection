package com.bridgelabz.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<AddressBookList> listAddressBookName = new ArrayList<>();
   
   public void addContact() {
	   if (listAddressBookName.isEmpty()) {
			System.out.println("Add AddressBook :- ");
			return;
	   }
	   else {
	    System.out.println("Please Enter The Name of Addressbook in list  to add Contacts- ");
	    String Bookname = scanner.next();   
	   
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
	
        Contact contacts = new Contact (FirstName , LastName , Address , City , State , ZipCode , PhoneNumber , Email);
 		
        if (CheckDuplicateContact(Bookname, FirstName)) {
        for (AddressBookList Adbookname : listAddressBookName) {
			if (Adbookname.AddressBookName.contains(Bookname)) {
				Adbookname.contact.add(contacts);
				for (Contact Contactname : Adbookname.contact) {
					System.out.println(Contactname.toString());
				}
			}
        }		
 		
 		System.out.println("Contact added Successfully.");
	}else {
		System.out.println("\n --> This Conatct with Name -> " + FirstName
				+ " <- Already Exist, please Input Another Name \n ");
		return;
	}
	  
   } 
}	   
   public void addMultipleContact() {
		System.out.println("Enter Number of Multiple Contacts to be added");
		int multipleContact = scanner.nextInt();
		for (int i = 1; i <= multipleContact; i++) {
			addContact();
		}
   }
   public boolean CheckDuplicateContact(String Bookname, String firstName) {
		for (AddressBookList Adbookname : listAddressBookName) {
			if (Bookname.equals(Adbookname.AddressBookName)) {
				for (Contact User : Adbookname.contact) {
					if (firstName.equals(User.firstName)) {
						return false;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		return true;
	}
    
  
    public void editContact() {
    	System.out.println("Enter firstName to edit contact");
    	String Name = scanner.next();
    	System.out.println("Enter Mail Id to edit Contact :- ");
		String email = scanner.next();
    	
    	 for (AddressBookList Adbookname : listAddressBookName) { 
    		if(Name.equals(Adbookname.AddressBookName)) {
    			for (Contact User : Adbookname.contact) {
					if (email.equals(User.email)) {
    		
    			System.out.println("Select Option to Update :" + "1. FirstName " + "2. LastName " + "3. Address " + "4.City " + "5.State "
						 + "6. ZipCode " + "7. PhoneNumber "+ "8. Email ");
    			int option = scanner.nextInt();
    			switch(option) {
    			case 1:
					System.out.println("Enter new FirstName");
					String newFirstName = scanner.next();
					User.setFirstName(newFirstName);
					System.out.println("Name Updated");
					break;

				case 2:
					System.out.println("Enter new Last Name");
					String newLastName = scanner.next();
					User.setLastName(newLastName);
					System.out.println("Name Updated");
					break;

				case 3:
					System.out.println("Enter New Address");
					String newAddress = scanner.next();
					User.setAddress(newAddress);
					System.out.println("Address Updated");
					break;

				case 4:
					System.out.println("Enter Updating city");
					String newCity = scanner.next();
					User.setCity(newCity);
					System.out.println("City Location Updated");
					break;
					

				case 5:
					System.out.println("Enter new State name");
					String newState = scanner.next();
					User.setState(newState);
					System.out.println("State location updated ");
					break;

				case 6:
					System.out.println("Enter new ZipCode");
					int newzip = scanner.nextInt();
					User.setZipCode(newzip);
					System.out.println("ZipCode Updated");
					break;

				case 7:
					System.out.println("Update PhoneNumber");
					int newphone = scanner.nextInt();
					User.setPhoneNumber(newphone);
					System.out.println("PhoneNumber Update");
					break;

				case 8:
					System.out.println("Update Email");
					String newMail = scanner.next();
					User.setEmail(newMail);
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
    		else {
    			continue;
    		}
    	 
    	 }
    	
    }
                 public void deleteContact() {
                	System.out.println("Enter  linked Email to Delete the Contact");
             		String DeleteContact = scanner.next();
             		
             		System.out.println("Enter Inputed Email To Delete Contact:-");
            		String email = scanner.next();
            		
             		for (AddressBookList Adbookname : listAddressBookName) {
            			if (DeleteContact.equals(Adbookname.AddressBookName)) {
            				for (Contact User : Adbookname.contact) {
            					if (email.equals(User.email)) {
            						Adbookname.contact.remove(User);
             				System.out.println("Contact Deleted Suucessfully");
             				break;

             			} else {
             				continue;
             			}
             		}
                 }else {
                	 continue;
                 }
             }
       }    		
                 public void SearchPersoninContact() {
             		System.out.println("Input the name of City And State to search person in the List ");
             		System.out.println(" Enter the City Name - ");
             		String City = scanner.next();
             		System.out.println(" Now Enter the State Name - ");
             		String State = scanner.next();
             		for (AddressBookList Adbookname : listAddressBookName) {
             			for (Contact User : Adbookname.contact) {
             				if (City.equals(User.city)) {
            					if (State.equals(User.state)) {
            						System.out.println("\n -> The Contact you are Searching by City - "+City+" &  State - "+State+" Is - "+User.firstName+". \n");
            					} else {
            						continue;
            					}
            				}
            			}
             		}
             }
                
                 public boolean Uniquename(String AddressBookName) {
             		if (listAddressBookName.isEmpty()) {
             			return true;
             		}

             		for (int i = 0; i < listAddressBookName.size(); i++) {
             			String getName = listAddressBookName.get(i).AddressBookName;
             			if (getName.equals(AddressBookName)) {
             				return false;
             			}
             		}
             		return true;
             	}

             	public void NewAddressBook() {
             		System.out.println(" Input Name of AddressBook - ");
             		String AddressBookName = scanner.next();

             		if (!Uniquename(AddressBookName)) {
             			System.out.println("The AddressBook with this Name Already Exist");
             			return;
             		}
             		AddressBookList AddressBookObj = new AddressBookList(AddressBookName);
             		listAddressBookName.add(AddressBookObj);

             		System.out.println("\n New Address Book Name is added to list.\n");
             	}

             	public void DisplayAddressBook() {
             		for (AddressBookList DisplayAddressBook : listAddressBookName) {
             			System.out.println(DisplayAddressBook);
             		}
             	}
                 
}
