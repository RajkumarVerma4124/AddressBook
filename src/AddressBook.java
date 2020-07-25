
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class BubbleSort
{
	public static <A extends Comparable<A>> void bubble(A[] arr,int n){
		int length=n;
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j].compareTo(arr[j+1])>0) {
						A temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
				}
			}
		}
		
		for(int k=0;k<n;++k) {
			System.out.print("Sorted Value : "+arr[k]+" ");
			System.out.println();
		}
	}
}  

@SuppressWarnings("unchecked")

public class AddressBook extends BubbleSort{
	static Scanner sc = new Scanner(System.in);
	

	public static void main(String [] args) throws FileNotFoundException, IOException, ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;
		
			while(true) {
			    System.out.println("****Welcome To Address Book***");
				System.out.println("1.Create Entry\n2.Edit the Existing Details \n3.Delete Entry Of Existing Person \n4.Add new Persons Details\n"
									+ "5.Read The Existing Data and Display \n6.Sort the Data Using their Key\n7.Search The Person Details\n8.Exit");
				System.out.print("Enter the choices : ");
				choice = sc.nextInt();
				switch (choice) {
					case 1 : System.out.print("Create Option Will Overwrite the Previous File Data Press Y To Continue : ");
								sc.nextLine();
				            	String option = sc.nextLine();
						        if(option.equals("Y"))
						        	try {
						        		create();
						        	} catch (IOException e) {
						        		// TODO Auto-generated catch block
						        		e.printStackTrace();
						        	}
						            break;
		                
					case 2 : edit();
		        			 break;
		            
					case 3 : delete();
							 break;
		            
					case 4: try {
				        		addNew();
				        	} catch (IOException e) {
				        	// TODO Auto-generated catch block
				        	e.printStackTrace();
				        	} break;
			        	
					case 5: read();
		            		break;
		            		
					case 6: System.out.print("Enter A Key Of Person To sort The Data :");
		            		sc.nextLine();
							String s = sc.nextLine();
		            		sortingData(s);
		            		break;
		            		
					case 7: searchData();
		                break;
		             
					case 8:
		                System.exit(1);
		             
					default:
		                System.out.println("Invalid choice");
		                break;
				
				}	
			}
		}
	
	static void create() throws IOException {
		// TODO Auto-generated method stub
		JSONObject personObject = new JSONObject();
		JSONArray personDetailArr = new JSONArray();
		
		System.out.print("Enter The No Of Records Of Person You Want To Enter : ");
		int records = sc.nextInt();
		for (int i = 0; i < records; i++)
		{
		JSONObject addrDetailsObj = new JSONObject();
		JSONObject personDetailsObj = new JSONObject();
		JSONArray addrArr = new JSONArray();
		System.out.print("Enter the First name of person : ");
		String fname  = sc.next();
		personDetailsObj.put("FirstName", fname);
		System.out.print("Enter the Last name of person : ");
		String lname  = sc.next();
		personDetailsObj.put("LastName", lname);
		System.out.print("Enter the City : ");
		String City  = sc.next();
		addrDetailsObj.put("CITY", City);
		System.out.print("Enter the State : ");
		String State  = sc.next();
		addrDetailsObj.put("STATE", State);
		System.out.print("Enter the ZipCode : ");
		long Zipcode  = sc.nextLong();
		addrDetailsObj.put("Zipcode", Zipcode);
		System.out.print("Enter the Phone number : ");
		long PhoneNumber  = sc.nextLong();
		personDetailsObj.put("Phone", PhoneNumber);
		addrArr.add(addrDetailsObj);
		personDetailsObj.put("ADDRESS", addrArr);
		personDetailArr.add(personDetailsObj);	
		}
		personObject.put("PERSON", personDetailArr);
		writes(personObject.toJSONString());
		System.out.println("Created Data Successfully\n");
		}
	
	static void edit() throws IOException, ParseException{
		// TODO Auto-generated method stub
		JSONParser parserFile = new JSONParser();
	    Object objOfFileData = parserFile.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
		JSONObject personDataObject = (JSONObject) objOfFileData;
		String filestrs = personDataObject.toString();
		System.out.print(filestrs+"\n");		
		JSONArray personDataArr = (JSONArray) personDataObject.get("PERSON");
		System.out.print("Enter Phone no. of a person you want to update : ");
		String number = sc.next();
		for(int i =0;i<personDataArr.size();i++) {
			JSONObject personDetails = (JSONObject) personDataArr.get(i);
			if(personDetails.get("Phone").toString().equals(number) == true) {
				System.out.print("Enter What field you want to update : ");
				String strAddr = sc.next();
				if(strAddr.equals("ADDRESS"))  {
					System.out.print("Enter what field you want to change : ");
					String strfeild = sc.next();
					System.out.print("Enter the Existing value : ");
					String strExistValue = sc.next();
					System.out.print("Enter the new value : ");
					String strNewValue = sc.next();
					
					JSONObject addrObject = (JSONObject) personDataArr.get(0);
					System.out.println(addrObject.toString());
					JSONArray addrArray = (JSONArray) addrObject.get("ADDRESS");
					
					Iterator<?> iterator = addrArray.iterator();
					while(iterator.hasNext()) {
						JSONObject objOfAddress = (JSONObject) iterator.next();
						System.out.print(objOfAddress.toString());
						String feildstr = objOfAddress.toString();
						System.out.println("String"+feildstr);
		
						if(objOfAddress.get(strfeild).equals(strExistValue) == true) {
							objOfAddress.put(strfeild, strNewValue);						
							System.out.println(objOfAddress.toString());
						}
					
						writes(personDataObject.toJSONString());
						System.out.print("Updated Data Successfully\n");
					}
				}
				else {
					System.out.print("Enter the Existing value : ");
					String strExistValue = sc.next();
					System.out.print("Enter the new value : ");
					String strNewValue = sc.next();				
					Iterator<?> itr = personDataArr.iterator();
					while(itr.hasNext()) {
						JSONObject objOfPerson = (JSONObject) itr.next();
						String feildstr = objOfPerson.toString();
						System.out.println("Person Details :"+feildstr);
						if(objOfPerson.get(strAddr).equals(strExistValue) == true) {
							objOfPerson.put(strAddr, strNewValue);						
								System.out.println("Person Details After Update : "+objOfPerson.toString());
						}		
						writes(personDataObject.toJSONString());
						System.out.print("Updated Data Successfully\n");

					}
				}
			}
			else {
				System.out.print("Wrong Key Entry Entry\n");
			}
		}	
	}
	
	static void delete() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parserFile = new JSONParser();
	    Object objOfFileData = parserFile.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
		JSONObject personDataObject = (JSONObject) objOfFileData;
		String filestr = personDataObject.toString();
		System.out.println(filestr+"\n");
		String str1 = "";
		System.out.print("Enter the phone number of person you want to delete : ");
		sc.nextLine();
		String strOfPhone = sc.nextLine();
		JSONArray arr4 = (JSONArray) personDataObject.get("PERSON");
		@SuppressWarnings("rawtypes")
		Iterator i = arr4.iterator();
		while(i.hasNext())
		{
			JSONObject objOfPerson = (JSONObject) i.next();
			System.out.println(objOfPerson.get("Phone"));
			if(objOfPerson.get("Phone").toString().equals(strOfPhone) == true)
			{
					str1 +=  objOfPerson.toString();
					System.out.println(objOfPerson.toString());
			}
		}
		String strDelete = filestr.replace(str1, "");
		Object newDataObject = parserFile.parse(strDelete);
		JSONObject newPersonDetailObj =(JSONObject) newDataObject;
		writes(newPersonDetailObj.toJSONString());
		System.out.print("Deleted Data Successfully\n");
	}
	
	static void addNew() throws IOException, ParseException{
		// TODO Auto-generated method stub
		JSONParser parserFile = new JSONParser();
	    Object objOfFileData = parserFile.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
	    JSONObject personObjectOfFile = (JSONObject) objOfFileData;
		JSONArray personDetailArr = (JSONArray) personObjectOfFile.get("PERSON");
		JSONObject personObject = new JSONObject();
		JSONObject addrDetailsObj = new JSONObject();
		JSONObject personDetailsObj = new JSONObject();
		JSONArray addrArr = new JSONArray();
		System.out.print("Enter the First name of person : ");
		String fname  = sc.next();
		personDetailsObj.put("FirstName", fname);
		System.out.print("Enter the Last name of person : ");
		String lname  = sc.next();
		personDetailsObj.put("LastName", lname);
		System.out.print("Enter the City : ");
		String City  = sc.next();
		addrDetailsObj.put("CITY", City);
		System.out.print("Enter the State : ");
		String State  = sc.next();
		addrDetailsObj.put("STATE", State);
		System.out.print("Enter the Zip : ");
		long Zipcode  = sc.nextLong();
		addrDetailsObj.put("Zipcode", Zipcode);
		System.out.print("Enter the Phone number : ");
		long PhoneNumber  = sc.nextLong();
		personDetailsObj.put("Phone", PhoneNumber);
		addrArr.add(addrDetailsObj);
		personDetailsObj.put("ADDRESS", addrArr);
		personDetailArr.add(personDetailsObj);						
		personObject.put("PERSON", personDetailArr);
		writes(personObject.toJSONString());
		System.out.print("Added New Data Successfully\n");
		}
		
	
	
	static void read() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		 JSONParser parseFile = new JSONParser();
		 Object objOfFileData = parseFile.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
		 JSONObject personObject = (JSONObject) objOfFileData;
		 writes(personObject.toJSONString());
		 System.out.println(personObject);
		
	}
	
	@SuppressWarnings("static-access")
	static void sortingData(String s) {
        String sortedpersonArray[];
        JSONParser parseFile = new JSONParser();
        try {
            Object objOfFileData = parseFile.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
            JSONObject personObject = (JSONObject) objOfFileData;
            JSONArray personArray = (JSONArray) personObject.get("PERSON");
            sortedpersonArray = new String[personArray.size()];
            for (int i = 0; i < personArray.size(); i++) {
            	if (s.equals("FirstName") || s.equals("Phone") || s.equals("LastName")) {
                    JSONObject objectOfPerson = (JSONObject) personArray.get(i);
                    sortedpersonArray[i] = objectOfPerson.get(s).toString().toLowerCase();
                    System.out.println("Person Key Value : "+sortedpersonArray[i]);
                } 
            	else {
            		JSONObject personObjectDetail = (JSONObject) personArray.get(i);
                    JSONArray addrArr = (JSONArray) personObjectDetail.get("ADDRESS");
                    JSONObject AddrObject = (JSONObject) addrArr.get(0);
                    sortedpersonArray[i] = AddrObject.get(s).toString().toLowerCase();
                    System.out.println("Address Key Value : "+sortedpersonArray[i]);
                }
            }

            BubbleSort b = new BubbleSort();
            b.bubble(sortedpersonArray, sortedpersonArray.length);
            JSONObject sortedpersonObject = new JSONObject();
            JSONArray sortedArray = new JSONArray();
           
            for (int i = 0; i < sortedpersonArray.length; i++)
            {
                for (int j = 0; j < sortedpersonArray.length; j++) {
                    JSONObject sortPersonDetail = (JSONObject) personArray.get(j);
                    if (s.equals("FirstName") || s.equals("Phone") || s.equals("LastName")) {
                        if (sortedpersonArray[i].equals(sortPersonDetail.get(s).toString().toLowerCase()) == true) {
                        	sortedArray.add(sortPersonDetail);
                        	System.out.print(sortedArray);
                        }
                    } 
                    else {
                        JSONArray addrArr = (JSONArray) sortPersonDetail.get("ADDRESS");
                        JSONObject jobj1 = (JSONObject) addrArr.get(0);
                        System.out.println(jobj1.toString());
                        if (sortedpersonArray[i].equals(jobj1.get(s).toString().toLowerCase()) == true) {
                        	sortedArray.add(sortPersonDetail);
                        	System.out.print(sortedArray);
                        }
                    }
                }

            }
            sortedpersonObject.put("PERSON", sortedArray);
            System.out.println(sortedpersonObject.toString());
            writes(sortedpersonObject.toJSONString());
        } 
        catch (Exception e) {
        }
    }
		
	static void searchData() throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parseSearch = new JSONParser();
		Object personSearch = parseSearch.parse(new FileReader("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json"));
		JSONObject personObject = (JSONObject) personSearch;
		JSONArray personArray = (JSONArray) personObject.get("PERSON");
		System.out.print("Enter the number or name of the person to search : ");
		String search = sc.next();
		for(int i = 0; i<personArray.size();i++){
			JSONObject objOfPerson = (JSONObject) personArray.get(i);
			if(objOfPerson.get("Phone").toString().equals(search) || objOfPerson.get("FirstName").toString().equals(search)) {
				System.out.println(objOfPerson);
			}
		}
	}

	static void writes(String str) throws IOException 
	{
		FileWriter files = new FileWriter("C:/Users//Raj//Desktop//CORE PROGRAMS//generics//myJSON2.json");
		files.write(str);
		files.flush();
		files.close();		
	}
	
}
