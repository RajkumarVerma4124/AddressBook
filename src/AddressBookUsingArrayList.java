
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import personDetailPackage.personsDetails;

public class AddressBookUsingArrayList {

	
	public static void main(String[] args) throws IOException {
		 String firstName;
		 String lastName;
		 String address;
		 String city;
		 String state;
		 int zip;
		 long phoneNo;
		 ArrayList<personsDetails> person = new ArrayList<>();
		 Scanner sc=new Scanner(System.in);
		 int choice=0,entryCount;
		 while(true)
		 {
			    System.out.println("****Welcome To Address Book***");
			    System.out.println("1. Create Entry");
			    System.out.println("2. Add New Person Entry");
				System.out.println("3. Update Your Existing Details");
				System.out.println("4. Delete A Particular Persons Entry");
				System.out.println("5. Display all Persons Details ");
				System.out.println("6. Sorting The person Data By ZipCode");
				System.out.println("7. Sorting The person Data LastName");
				System.out.println("8. Read and Write  the File");
				System.out.println("9. Exit");
				System.out.println("Please Enter your choice  : ");
				choice = sc.nextInt();
				switch (choice) {
				
				
				case 1:
					System.out.println("Create The Persons Record");
					System.out.println(" ");
					System.out.println("Enter number of Details to be entered");
					entryCount = sc.nextInt();
					for(int i=0;i<entryCount;i++)
					{
						System.out.println("Enter First Name :");
						firstName=sc.next();
						System.out.println("Enter Last Name :");
						lastName=sc.next();
						System.out.println("Enter Address :");
						address=sc.next();
						System.out.println("Enter State :");
						state=sc.next();
						System.out.println("Enter City :");
						city=sc.next();
						System.out.println("Enter Zip Code :");
						zip=sc.nextInt();
						System.out.println("Enter Phone Number:");
						phoneNo=sc.nextLong();
						personsDetails personAdd = new personsDetails(firstName, lastName, address, city, state, zip, phoneNo);
						person.add(personAdd);
						System.out.println("Created The Person Record sucessfully.");
						System.out.println(" ");
										
					}
					break;
					
				case 2:
					System.out.println("Add New Persons Record");
					System.out.println(" ");
						System.out.println("Enter First Name :");
						firstName=sc.next();
						System.out.println("Enter Last Name :");
						lastName=sc.next();
						System.out.println("Enter Address :");
						address=sc.next();
						System.out.println("Enter State :");
						state=sc.next();
						System.out.println("Enter City :");
						city=sc.next();
						System.out.println("Enter Zip Code :");
						zip=sc.nextInt();
						System.out.println("Enter Phone Number:");
						phoneNo=sc.nextLong();
						personsDetails personAdd = new personsDetails(firstName, lastName, address, city, state, zip, phoneNo);
						person.add(personAdd);
						System.out.println("Added the New Person Record sucessfully.");
						System.out.println(" ");
					break;
					
				case 3:
					   System.out.println("******Updated Record******");
					   System.out.println("Enter Phone Number for updation : ");
						phoneNo = sc.nextLong();
						for (int i = 0; i < person.size(); i++) {
							
							if (person.get(i) != null && person.get(i).getPhoneNo()== phoneNo) {
								   System.out.println("Person You Serached For Editing : "+person.get(i));
								   System.out.println("Enter Field Value You Want To update : ");
								   String field = sc.next();
								   if(person.get(i).getFirstName() == field) {
									   System.out.println("Enter New First Name :");
									   firstName=sc.next();
									   person.get(i).setFirstName(firstName);
									   System.out.println("Updated Person FirstName Succesfully");

								   }
								   else if(person.get(i).getLastName()==field) {
									   System.out.println("Enter New Last Name :");
									   lastName=sc.next();
									   person.get(i).setLastName(lastName);
									   System.out.println("Updated Person LastName Succesfully");

								   }
								   else if(person.get(i).getAddress()==field) {
									   System.out.println("Enter New Address :");
									   address=sc.next();
									   person.get(i).setAddress(address);
									   System.out.println("Updated Person Address Succesfully");

								   }
								   else if(person.get(i).getState()==field) {
									   System.out.println("Enter New State :");
									   state=sc.next();
									   person.get(i).setState(state);
									   System.out.println("Updated Person State Succesfully");

								   }
								   else if(person.get(i).getCity()==field) {
									   System.out.println("Enter New City :");
									   city=sc.next();
									   person.get(i).setCity(city);
									   System.out.println("Updated Person City Succesfully");
								   }
								   else {
									   System.out.println("Enter Field Value You Want To update : ");
									   int fieldvalue = sc.nextInt();
									   if(person.get(i).getZipCode()==fieldvalue) {
										   System.out.println("Enter New Zip :");
										   zip=sc.nextInt();
										   person.get(i).setZipCode(zip);
										   System.out.println("Updated Person City Succesfully");

									   }
									   else {
										   System.out.println("Field Value Doesnt Match");
									   }
								   }
							}
							else {
								   System.out.println("Field Value Doesnt Match");
							}
						}
						break;
				
				case 4:
					System.out.println("Delete the record details");
					System.out.println(" ");
					System.out.println("Enter phone number for deletion : ");
					phoneNo= sc.nextLong();
					for (int i = 0; i <= person.size(); i++) {

						if (person.get(i) != null && person.get(i).getPhoneNo() == phoneNo) {
							person.get(i).equals(null);
							System.out.println("Record deleted successfully");
						}
					}

					break;
					
				case 5:
					
					System.out.println("Display all Addressbook record");
					System.out.println(" ");
					
					for (int i = 0; i < person.size(); i++) {
						System.out.println(person.get(i));
					}

					break;
					
				case 6:
					System.out.println("Search Addressbook details by Phone Number: ");
					System.out.println(" ");
					System.out.println("Enter Phone Number for search : ");
					phoneNo = sc.nextLong();
					for (int i = 0; i < person.size(); i++) {

						if (person.get(i) != null && person.get(i).getPhoneNo()== phoneNo) {
							System.out.println(person.get(i));
						}
					}
					break;

				case 7: 
					int [] zipArray = new int[person.size()];
					for (int i = 0; i < person.size(); i++) {
						int temp = (int) person.get(i).getZipCode();
						zipArray[i] = temp;
					}
					Arrays.sort(zipArray);
					System.out.print(Arrays.toString(zipArray)+"\n");
					for (int i = 0; i < person.size(); i++) {
						for (int j = 0; j < person.size(); j++) {
							if (person.get(i) != null && zipArray[i] == person.get(j).getZipCode()) {
								System.out.println(person.get(j));
							}
							
						}

					}
					
					

					break;
					
				case 8: 
					String [] LastNameArray = new String[person.size()];
					for (int i = 0; i < person.size(); i++) {
						String temp = (String) person.get(i).getLastName();
						LastNameArray[i] = temp;
					}
					Arrays.sort(LastNameArray);
					System.out.print(Arrays.toString(LastNameArray)+"\n");
					for (int i = 0; i < person.size(); i++) {
						for (int j = 0; j < person.size(); j++) {
							if (person.get(i) != null && LastNameArray[i] == person.get(j).getLastName()) {
								System.out.println(person.get(j));
							}
							
						}

					}

					break;
						
				case 9: 
					FileReader personFile = new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//JSON//myJSON.json");
					int i;
					while((i=personFile.read())!=-1) {
					System.out.print((char)i);
					
					FileWriter files = new FileWriter("C:/Users//Raj//Desktop//CORE PROGRAMS//JSON//myJSON1.json");
					files.write((char)i);
					files.flush();
					files.close();			
					}
					 break;	
					 
	

				case 10:

					System.exit(0);

				default:
					System.out.println("Please enter correct choice");
				
					
			}
			sc.close();
		} 
	}
}