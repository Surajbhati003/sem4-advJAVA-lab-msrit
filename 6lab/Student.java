package slab6;

public class Student {
	String name, address, usn;
	int age;
	double cgpa;
	public Student(String name, String address, String usn, int age, double cgpa) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.usn=usn;
		this.cgpa=cgpa;
	}
	public String toString() {
		return "Name: "+name+"\tUSN: "+usn+"\tAddress: "+address+"\tAge: "+age+"\tcgpa: "+cgpa;
	}
}