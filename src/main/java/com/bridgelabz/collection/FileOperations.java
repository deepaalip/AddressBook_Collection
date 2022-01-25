package com.bridgelabz.collection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;

public class FileOperations {
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
public void writeContactsIntoTextFile() throws IOException {
		
		/*** Writing into text file using FILE-IO. ***/
		FileWriter fileWriter = new FileWriter("files/AddressBookIO.txt");
		
		String stringAddressBookList = AddressBookList.AddressBookName.toString();
		
		for(int i = 0; i < stringAddressBookList.length(); i++) {
			fileWriter.write(stringAddressBookList.charAt(i));
			fileWriter.flush();
		}
		fileWriter.close();

		System.out.println("Data Added into AddressBookIO.txt File.\n");
	}
	
	// reading contacts data from text file.
	public void readContactsFromTextFile() throws IOException {
		System.out.println("---------------READING FROM TEXT FILE--------------");
		
		/** Writing into file if file does not exist(Empty file is created) in system. **/
		Path path = Paths.get("files/AddressBookIO.txt");
		if(!Files.exists(path)) {
			System.out.println("OOPS! File is not there. Creating file....");
			writeContactsIntoTextFile();
		}
		
		FileInputStream fileInputStream = new FileInputStream("files/AddressBookIO.txt");
		int i = 0;
		while((i = fileInputStream.read()) != -1) {
			System.out.print((char)i);
		}
		fileInputStream.close();
	}
 	public void writeContactsIntoCSV() throws IOException {

 		List<String[]> stringsAddressBook = new ArrayList<>();

 		PrintWriter printWriter = new PrintWriter("AddressBookIO.csv");	
 		
 		CSVWriter csvWriter = new CSVWriter(printWriter);

 		
 		AddressBookList.AddressBookName.forEach(addressBook -> addressBook.contact.stream().forEach(ad -> {
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
     
 	public void writeContactsIntoJSON_File() throws IOException {
		
		String output = gson.toJson(AddressBookList.AddressBookName);
		FileWriter fileWriter = new FileWriter("AddressBookIO.json");
		fileWriter.write(output);
		fileWriter.close();
		
		System.out.println("Contacts are added to AddressBook.json file successfully.");
	}
	
	
	public void readContactsFromJSON_File() throws IOException {
		System.out.println("---------------READING FROM JSON FILE--------------");
		
		Path path = Paths.get("AddressBookIO.json");
		if(!(Files.exists(path))) {
			System.out.println("OOPS! JSON file is not there, Creating JSON file..");
			writeContactsIntoJSON_File();
		}
		else {
			FileReader fileReader = new FileReader("files/AddressBook.json");
			Object temp = gson.fromJson(fileReader, Object.class);
			System.out.println(temp);
		}
	}
}
