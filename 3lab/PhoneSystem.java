package slab3;
/*
 * Write a Program that simulates a telephone that records missed incoming calls. For each missed call, store the time of call, telephone number of
origin, and name of the caller if the name is available. For unlisted numbers, set the name to “private caller”. Choose or extend the most
appropriate collection class and provide the following features.
Numbers are recalled in the order they arrive
After each number display, the user can select
i. To delete the call
ii. To display the call details (number, caller name and time).
 Delete the number if user specifies a number to delete.
Write a helper class to represent an incoming call with fields to hold the number, name of the caller, and time of the call. Write a tester call that
stores the several numbers, simulate the user pressing the missed-calls button and finally prints the entire collection of stored calls.*/
import java.util.*;
import java.time.LocalDateTime;
public class PhoneSystem 
{
	List<Call> missedCalls=new LinkedList<>();
	
	void addCall(String phoneNumber, String callerName, LocalDateTime callTime) 
	{
		missedCalls.add(new Call(phoneNumber, callerName, callTime));
	}
	
	void deleteCall(String phoneNumber) 
	{
		missedCalls.removeIf(call->call.getPhoneNumber().equals(phoneNumber));
	    System.out.println("Call deleted.");
	}
	
	void displayCalls() 
	{
		if(missedCalls.isEmpty()) 
		{
			System.out.println("No missed calls!!!");
		} 
		else 
		{
			System.out.println("Missed Calls: ");
			for(int i=0; i<missedCalls.size(); i++) 
			{
				System.out.println((i+1)+". "+missedCalls.get(i));
			}
		}
	}
	
	void handleUserInput() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Select an option: ");
			System.out.println("1. Add a missed call");
			System.out.println("2. Delete a call");
			System.out.println("3. Display all calls");
			System.out.println("4. Exit");
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==4) break;
			switch(choice) {
			    case 1: System.out.println("Enter phone number: ");
			    		String phoneNumber=sc.nextLine();
			    		System.out.println("Enter caller name: ");
			    		String callerName=sc.nextLine();
			    		LocalDateTime callTime=LocalDateTime.now();
			    		addCall(phoneNumber, callerName.isEmpty() ? null : callerName, callTime);
			    		System.out.println("Missed call added");
			    		break;
			    case 2: System.out.println("Enter the phone number to delete: ");
			    		String phoneNumberToDelete=sc.nextLine();
			    		deleteCall(phoneNumberToDelete);
			    		break;
			    case 3: displayCalls();
			    		break;
			    default: System.out.println("Invalid Option!!!");		
			}
		}
	}
	public static void main(String[] args) {
		PhoneSystem phoneSystem=new PhoneSystem();
		phoneSystem.addCall("123-456-7890", "Alice", LocalDateTime.now().minusHours(1));
		phoneSystem.addCall("098-765-4321", null, LocalDateTime.now().minusHours(2));
		phoneSystem.addCall("555-555-5555", "Bob", LocalDateTime.now().minusHours(3));
		phoneSystem.handleUserInput();
		
	}
}