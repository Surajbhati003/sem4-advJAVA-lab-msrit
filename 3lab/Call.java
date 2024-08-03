package slab3;
import java.time.LocalDateTime;
public class Call {
	String phoneNumber;
	String callerName;
	LocalDateTime callTime;
	Call(String phoneNumber, String callerName, LocalDateTime callTime) {
		this.phoneNumber=phoneNumber;
		this.callerName=callerName!=null? callerName: "privateCaller";
		this.callTime=callTime;
	}
	String getPhoneNumber() {
		return phoneNumber;
	}
	String getCallerName() {
		return callerName;
	}
	public String toString() {
		return "PhoneNumber: "+phoneNumber+"\tName: "+callerName+"\t\tTime: "+callTime;
	}
}