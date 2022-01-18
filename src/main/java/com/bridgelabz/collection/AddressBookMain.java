package com.bridgelabz.collection;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner scanner = new Scanner(System.in);
  public static void main (String[] args) throws IOException
  {
	  System.out.println("Welcome to Address Book Program");
	  AddressBook addressBook = new AddressBook();
	  
	  System.out.print("Enter an option AddressBook Application ,Enter=1 ,Exit=2  ");
		int enterExit = scanner.nextInt();
		if (enterExit == 1) {

			while (enterExit != 2) {
				System.out.println("Choose which operation you want to perform from below list = ");
				System.out.println("1.Add Contact");
				System.out.println("2.Edit Contact");
				System.out.println("3.Delete Contact");
				System.out.println("4.Add New AddressBook in List");
				System.out.println("5.Search person in contact");
				System.out.println("6.countby city and state");
				System.out.println("7.view contact by city");
				System.out.println("8.view contact by state");
				System.out.println("9.sorted contact");
				System.out.println("10.sorted contact bycity");
				System.out.println("11.sorted contact by state");
				System.out.println("12.Write The IO File");
				System.out.println("13.Read The IO File");
				System.out.println("14.Display Address Book");
				System.out.println("15.Write into CSV file.");
				System.out.println("16.Read from CSV file.");
				System.out.println("17.Exit from the Application");

				System.out.println("Enter your choice ");
				int userChoice = scanner.nextInt();

				switch (userChoice) {
				case 1:
					addressBook.addMultipleContact();
					break;
				case 2:
					addressBook.editContact();
					break;
				case 3:
					addressBook.deleteContact();
					break;
				case 4:
					addressBook.NewAddressBook();
					break;
				case 5:	
					addressBook.SearchPersoninContact();
					break;
				case 6:
					addressBook.CountbyCityandState();
					break;
				case 7:
					addressBook.viewByCity();
					break;
				case 8:
					addressBook.viewByState();
					break;
				case 9:
					addressBook.contactSorting();
					break;
				case 10:
					addressBook.contactSortingByCity();
					break;	
				case 11:
					addressBook.contactSortingByState();
					break;
				case 12:   
					addressBook.writeTheFile();
					break;		
				case 13:
		     		addressBook.readTheFile();
					break;
				
				case 14:   
					addressBook.displayAddressBook();
					break;	
				case 15:
					addressBook.writeContactsIntoCSV();
					break;
				case 16:
					addressBook.readContactsFromCSV();
					break;
				default:
					System.out.println("Press valid button To choose option ");
				}
				if (userChoice == 17) {
					System.out.println("You are Exited from Addressbook");
					break;
				}
			}
		} else if (enterExit == 2) {
			System.out.println("Exited from Addressbook");
		} else {
			System.out.println("Press Valid button Enter=1 ,Exit=2");
		}
	}

	  
	  
  
}
