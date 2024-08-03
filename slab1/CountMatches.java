/*
Write program to demonstrate the working of String methods:
To determine frequency of substrings in a string
To check for anagrams (two strings having same characters)*/
package slab1;
import java.util.*;
public class CountMatches {
	public static int frequency(String source, String part) {
		if(source==null || source.isEmpty() || part==null || part.isEmpty())
			return 0;
		int count=0;
		for (int pos=0; (pos=source.indexOf(part, pos))!=-1; count++) {
			pos+=part.length();
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string"); 
		String str=sc.nextLine();
		System.out.println("Enter the substring"); 
		String substr=sc.nextLine();
		System.out.println(frequency(str, substr)); 
	}
}