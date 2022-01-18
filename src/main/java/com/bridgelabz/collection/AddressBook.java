package com.bridgelabz.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;

public class AddressBook {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<AddressBookList> listAddressBookName = new ArrayList<>();
   static ArrayList<Contact> AddressBook = new ArrayList<Contact>();
   File file = new File("C:/Users/DELL/eclipse-workspace/AddressBookCollection/src/main/resource/AddressBookIO.txt");
   
    
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
					AddressBook.add(contacts);
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
					if (firstName.equals(User.getFirstName())) {
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
					if (email.equals(User.getEmail())) {
    		
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
            					if (email.equals(User.getEmail())) {
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
                 public void SearchPersoninContact() {
             		System.out.println("Input the name of City And State to search person in the List ");
             		System.out.println(" Enter the City Name - ");
             		String City = scanner.next();
             		System.out.println(" Now Enter the State Name - ");
             		String State = scanner.next();
             		for (AddressBookList Adbookname : listAddressBookName) {
             			for (Contact User : Adbookname.contact) {
             				if (City.equals(User.getCity())) {
            					if (State.equals(User.getState())) {
            						System.out.println("\n -> The Contact you are Searching by City - "+City+" &  State - "+State+" Is - "+User.getFirstName()+". \n");
            					} else {
            						continue;
            					}
            				}
            			}
             		}
             }
                
                 public void CountbyCityandState() {
             		System.out.println("Input the name of City And State to Count Persons - ");
             		System.out.println(" Enter the City Name - ");
             		String City = scanner.next();
             		int Countcity = 0;
             		System.out.println(" Enter the State Name - ");
             		String State = scanner.next();
             		int Countstate = 0;

             		for (AddressBookList Adbookname : listAddressBookName) {
             			for (Contact User : Adbookname.contact) {
             				if (City.equals(User.getCity())) {
             					Countcity++;
             					if (State.equals(User.getState())) {
             					Countstate++;
             					}
             				}
             			} 
             			
             			
             			System.out.println(City + " "+Countcity+" "+State+" "+Countstate);
             			
             		}
                 }
              public void viewByCity() {
            	 
            	  System.out.println("enter city:");
            	  String cityName = scanner.next();
            	  
                  Set<Contact> citydetails = AddressBook.stream().filter(c->c.getCity() .equals(cityName)).collect(Collectors.toSet());
                  for(Contact con :  citydetails) { 
                      System.out.println(con.getCity()+" "+con.getFirstName()+" "); 
                   } 
            	
            	
                }
              
                public void viewByState() {
                System.out.println("enter state:");
              	String stateName = scanner.next();
              	Set<Contact> statedetails = AddressBook.stream().filter(c->c.getState() .equals(stateName)).collect(Collectors.toSet());
                for(Contact con :  statedetails) { 
                    System.out.println(con.getState()+" "+con.getFirstName()+" "); 
                 } 
             	   }
                
                public void contactSorting() {
            	
            		AddressBook.stream()
            		.sorted((contact1,contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
            		.forEach(contact -> System.out.println(contact));
            				
                }
                public void contactSortingByCity() {
                	
            		AddressBook.stream()
            		.sorted((contact1,contact2) -> contact1.getCity().compareTo(contact2.getCity()))
            		.forEach(contact -> System.out.println(contact));
            				
                }
                
                 public void contactSortingByState() {
                	
            		AddressBook.stream()
            		.sorted((contact1,contact2) -> contact1.getState().compareTo(contact2.getState()))
            		.forEach(contact -> System.out.println(contact));
            				
                }
             	
             	
                 
             	
             	
             	public void writeTheFile() throws IOException  {
             		FileWriter fileWriter = new FileWriter("AddressBookIO.txt");
            		
            		String Contact = AddressBook.toString();
            		
            		for(int i = 0; i < Contact.length(); i++) {
            			fileWriter.write(Contact.charAt(i));
            			fileWriter.flush();
            		}
            		fileWriter.close();

            		System.out.println("Data Added successfully");
            	}
             	
             	public void readTheFile() throws IOException {
            		
            		Path path = Paths.get("AddressBookIO.txt");
            		if(!Files.exists(path)) {
            			System.out.println("OOPS! File is not there. Creating file....");
            			writeTheFile();
            		}
            		
            		FileInputStream fileInputStream = new FileInputStream("AddressBookIO.txt");
            		int i = 0;
            		while((i = fileInputStream.read()) != -1) {
            			System.out.print((char)i);
            		}
            		fileInputStream.close();
            	}
            		
            	

             	public void displayAddressBook() {
             		for (AddressBookList DisplayAddressBook : listAddressBookName) {
             			System.out.println(DisplayAddressBook);
             		}
             	}
             	public void writeContactsIntoCSV() throws IOException {

             		List<String[]> stringsAddressBook = new ArrayList<>();

             		PrintWriter printWriter = new PrintWriter("AddressBookIO.csv");	
             		
             		CSVWriter csvWriter = new CSVWriter(printWriter);

             		
             		listAddressBookName .forEach(addressBook -> addressBook.contact.stream().forEach(ad -> {
             					stringsAddressBook.add(new String[] { ad.getFirstName(), ad.getLastName(), 
             					ad.getAddress(), ad.getCity(), ad.getState(),Integer.toString(ad.getZipCode()),
             					Long.toString(ad.getPhoneNumber()), ad.getEmail() });}));
             		
             		csvWriter.writeAll(stringsAddressBook);    
             		csvWriter.flush();
             		csvWriter.close();
             		
             		System.out.println("Contacts are added to AddressBook.csv file successfully.");
             	}
             	

             	public void readContactsFromCSV() throws IOException {
            		Path path = Paths.get("AddressBookIO.csv");
            		if(!Files.exists(path)) {
            			System.out.println("OOPS! CSV file is not there. Creating CSV file...");
            			writeContactsIntoCSV();
            		}
            		
            		BufferedReader bufferedReader = new BufferedReader(new FileReader("AddressBook.csv"));
            		String line = "";
            		while ((line = bufferedReader.readLine()) != null) {
            			String[] contact = line.split(",");
            			System.out.println("AddressBook [firstName=" + contact[0] + ", lastName=" + contact[1] + ", address="
            					+ contact[2] + ", cityName=" + contact[3] + ", stateName=" + contact[4] + ", zip=" + contact[5]
            					+ ", phoneNumber=" + contact[6] + "]");
            		}
            	}
                 
}
