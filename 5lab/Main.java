package slab4;
/*Write a Java program using user-defined storage classes to create a book database and store it in a Collection List.
Book collection should include title, author, publisher and price.
Write a method to sort the books in ascending order of price and store it in another list. Maintain the book details with respect to a
unique book id.
Prompt for an author name and list all the books with the same author name. */
// slab5 is also same changes are threshold price function and sort by publisher specific
import java.util.*;
public class Main 
{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<Book>();

        // Adding books to the collection
        bookList.add(new Book("Dbms basics", "auth1", "pub1", 12345.00));
        bookList.add(new Book("Dbms advanced", "auth1", "pub2", 22222.10));
        bookList.add(new Book("Java J2EE", "auth2", "pub1", 123.566));
        bookList.add(new Book("Machine Learning", "auth3", "pub3", 567.56));

        // Sorting books by price and storing in another list
        ArrayList<Book> sortedByPrice = new ArrayList<Book>(bookList);
        Collections.sort(sortedByPrice, new PriceCompare());
        System.out.println("*********** Sorted Collection by Price **********");
        for (Book b : sortedByPrice) {
            System.out.println(b);
        }
        System.out.println("--------------------------------");

        // Maintaining book details with respect to a unique book ID
        HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
        int id = 1;
        for (Book b : bookList) {
            bookMap.put(id, b);
            id++;
        }

        // Prompt for an author name and list all the books with the same author name
        System.out.print("Enter author name: ");
        String authorName = input.nextLine();
        System.out.println("Books by author " + authorName + ":");
        for(Book book: bookList) {
        	if(book.author.equals(authorName)) {
        		System.out.println(book);
        	}
        }
        System.out.println("--------------------------------");
        
     // Prompt for an author name and list all the books with the same publisher name
        System.out.print("Enter publisher name: ");
        String publisherName = input.nextLine();
        System.out.println("Books by publisher " + publisherName + ":");
        for(Book book: bookList) {
        	if(book.publisher.equals(publisherName)) {
        		System.out.println(book);
        	}
        }
        System.out.println("--------------------------------");

        // Create a new list holding all the book details with price greater than a user-specified price
        System.out.print("Enter the price threshold: ");
        double priceThreshold = input.nextDouble();
        System.out.println("Books with price greater than " + priceThreshold + ":");
        for (Book book : bookList) {
            if (book.price > priceThreshold) {
            	System.out.println(book);
            }
        }
        System.out.println("--------------------------------");

        input.close();
    }
}
