package slab2;
/*
 * Write a program to create generic Stack class with push(), pop(), clear(),
 * isEmpty() and display() methods. 
 * Demonstrate creation of Stack of String
and Integer objects.       */
import java.util.*;
class Stack<T> 
{
	List<T> elements=new ArrayList<>();
	final int maxSize;
	Stack(int maxSize) 
	{
		this.maxSize=maxSize;
	}
	void push(T element) 
	{
		if(elements.size()<maxSize) 
		{
			elements.add(element);
		}
	}
	T pop() 
	{
		if(elements.isEmpty()) return null;
		return elements.remove(elements.size()-1);
	}
	T peek() 
	{
		if(elements.isEmpty()) return null;
		return elements.get(elements.size()-1);
	}
	void clear() 
	{
		elements.clear();
	}
	void display() 
	{
		if(elements.isEmpty()) 
		{
			System.out.println("Stack is Empty");
		} else 
		{
			System.out.println("Stack contents: " +elements);
		}
	}
}

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> stringStack=new Stack<>(2);
		stringStack.push("Hello");
		stringStack.push("World");
		stringStack.display();
		stringStack.push("Overflow");
		System.out.println("Peeked element: "+stringStack.peek());
		System.out.println("Popped element: "+stringStack.pop());
		stringStack.display();
		
		Stack<Integer> integerStack=new Stack<>(3);
		integerStack.push(1);
		integerStack.push(2);
		integerStack.push(3);
		integerStack.display();
		integerStack.push(4);
		System.out.println("Peeked element: "+integerStack.peek());
		System.out.println("Popped element: "+integerStack.pop());
		integerStack.display();
		integerStack.clear();
		integerStack.display();
	}
}