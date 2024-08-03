package slab4;
public class Book {
	String title, author, publisher;
	Double price;
	 
	Book(String title, String author, String publisher, Double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	 
	public String toString() {
		return "Book Details: \t\tTitle: "+title +"\t\tAuthor: "+author+"\t\tPublisher: "+publisher+"\t\tPrice: "+price;
	}
}
