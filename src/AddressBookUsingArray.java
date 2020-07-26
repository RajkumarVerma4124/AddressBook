import java.util.Scanner;
import personDetailPackage.personsDetails;

public class AddressBookUsingArray {
	public static void main(String[] args) {
	String firstName;
	String lastName;
	String address = null;
	String city = null;
	String state = null;
	int zipCode = 0;
	long phoneNo = 0;
	int count=0;
	Scanner sc=new Scanner(System.in);
	personsDetails personArray[]=new personsDetails[20];
	
		while (true) {
			System.out.println("****Welcome To Address Book***");
		    System.out.println("1. Create Entry");
			System.out.println("2. Update Your Existing Details");
			System.out.println("3. Delete A Particular Persons Entry");
			System.out.println("4. Display all Persons Details ");
			System.out.println("5. Sorting The person Data By ZipCode");
			System.out.println("6. Sorting The person Data LastName");
			System.out.println("7. Exit");
			System.out.println("Please Enter your choice  : ");
			System.out.println("Enter your Choice:");
			int ch=sc.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Enter number Of Entries : ");
					int entry=sc.nextInt();
					    for(int i=0;i<entry;i++) {
					    System.out.print("Enter the First Name : ");
					    firstName=sc.next();
					    System.out.print("Enter the Last Name  : ");
					    lastName=sc.next();
					    System.out.print("Enter Address You Reside In Currently : ");
					    address=sc.next();
					    System.out.print("Enter City You Live in : ");
					    city=sc.next();
					    System.out.print("Enter State You lIve in : ");
					    state=sc.next();
					    System.out.print("Enter Zipcode Of City : ");
					    zipCode=sc.nextInt();
					    System.out.print("Enter Mobile No Of The Person : ");
					    phoneNo=sc.nextLong();
					    personArray[count]=new personsDetails(firstName,lastName,address,city,state,zipCode,phoneNo);
					    count++;
				    }
					    
				    System.out.println("Added successfully\n");
				    break;
				    
				case 2:
				      System.out.println("Enter Mobile No Of The Person You Want To Update:");
				      phoneNo=sc.nextLong();
				      
					    for(int i=0;i<count;i++){
					    	if(personArray[i].getPhoneNo()==phoneNo){
					    		System.out.println("Searched Person Is : "+personArray[i]);
							    System.out.println("Enter the Field Value You Want To Change : ");
							    String fieldName=sc.next();
						    	if(personArray[i].getFirstName() == fieldName){
						    		personArray[i].setFirstName(fieldName);
						    	}
						    	else if(personArray[i].getLastName() == fieldName ) {
						    		personArray[i].setLastName(fieldName);
						    	}
						    	else if(personArray[i].getAddress() == fieldName ) {
						    		personArray[i].setAddress(fieldName);
						    	}
						    	else if(personArray[i].getCity() == fieldName ) {
						    		personArray[i].setCity(fieldName);
						    	}
						    	else if(personArray[i].getState() == fieldName ) {
						    		personArray[i].setState(fieldName);
						    	}
						    	else {
						    		 System.out.println("Do You Want To Change The Mobile No. Press 1 And To Change ZipCode Press @:");
						    		 String option = sc.next();
						    		 if( option.equals("1") ) {
										    System.out.println("Enter The New Mobile No:");
										    long newPhoneNo = sc.nextInt();
										    personArray[i].setPhoneNo(newPhoneNo);
						    		 }
						    		 else if (option.equals("2")) {
						    			 System.out.println("Enter The New ZipCode:");
										    int newZipCode = sc.nextInt();
										    personArray[i].setPhoneNo(newZipCode);
						    			 
						    		 }
									  
						    	}
					    	}
					    }
					    System.out.println("Updated successfully\n");
					    break;
					    
				case 3:
				    System.out.println("Enter Mobile No:");
				    phoneNo=sc.nextLong();
				     
				    for(int i=0;i<count;i++) {
				    	if(personArray[i].getPhoneNo()==phoneNo){
				    	personArray[i]=null;
				    	}
				    }
				    System.out.println("Entry is Deleted");
				    break;
				    
			    case 4:
			    	for(int i=0;i<count;i++) {
					    System.out.println(personArray[i]);
					}
				    System.out.println("\n");
				    break;
				 	   
			    case 5:
				    personsDetails tempZip;
				    for(int i=0; i < count; i++){  
		                for(int j=1; j < (count-i); j++){  
		                         if(personArray[j-1].getZipCode() > personArray[j].getZipCode()){    
		                        	 tempZip = personArray[j-1];  
		                                personArray[j-1] = personArray[j];  
		                                personArray[j] = tempZip;  
		                        }  
		                }  
					}
				    for(int i=0;i<count;i++) {
				    	System.out.println(personArray[i]);
				    }
				    
				    System.out.println("\n");
				    break;
	   
			    case 6:
				    personsDetails tempLastName;
				    for(int i=0; i < count; i++){  
			            for(int j=1; j < (count-i); j++){  
			                 if(personArray[j-1].getLastName().compareTo(personArray[j].getLastName())>0){    
			                	 tempLastName = personArray[j-1];  
			                        personArray[j-1] = personArray[j];  
			                        personArray[j] = tempLastName;  
			                 }  
			            }  
				    }
			    for(int i=0;i<count;i++) {
			    	System.out.println(personArray[i]);
			    }
			    System.out.println("\n");
			    break;
			   
			    case 7:
			    	System.exit(0);
			    	
			    default:
			    	System.out.println("Invalid Input\n");
			}
			sc.close();
		}
	}
}
