/**
 * @author Link Parrish
 * grabs a book catalog from an input file then allows you to search the catalog
 */
package assg4_parrishl21;

import java.util.Scanner;
import java.io.*;

public class bookSearch {

	public static void main(String[] args) {
		
		String filename = "assg4_catalog.txt";
		Scanner keyboard = new Scanner(System.in);
		Scanner input = null;
		Book[] books = new Book[100];
		String toSearch = "";
		int i = 0;

		// try catch for opening the file
		try {
			input = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error: file '" + filename + "' not found");
			System.exit(1);
		}
		
		// loop to create the book array
		while (input.hasNextLine()) {
			
			String id = input.next();
			String title = input.next();
			String isbn = input.next();
			String author = input.next();
			char category = input.next().charAt(0);
			
			// create the book object
			Book temp = new Book(id, title, isbn, author, category);
			
			// try catch for catching duplicate book id's
			try {
				
				// checks to see if the array is empty, the code below this doesn't work if the array is empty
				if (i == 0) {
					books[i] = temp;
					i++;
				}
				
				// checks the current id against the catalog
				else {
					for (int j = 0; j < i; j++) {
						if (books[j].getId().equals(id)) {
							throw new BookIdAlreadyExistException(id);
						}
					}
					books[i] = temp;
					i++;
				}
			}
			
			// catches a book id already exists exceptions and prints the error
			catch (BookIdAlreadyExistException e) {
				System.out.println(e);
			}
		}		
		
		// displays the book catalog
		for (int j = 0; j < i; j++) {
			System.out.println(books[j]);
		}
		
		// loop to search the catalog
		while (!toSearch.equals("STOP")) {
			
			// try catch for catching if the book id doesn't exist in the catalog
			try {
				System.out.print("\nEnter a id to search for, enter STOP to stop: ");
				toSearch = keyboard.nextLine();
				
				// searches the catalog as long as the input isn't STOP
				if (!toSearch.equals("STOP")) {
					int index = Book.bookSearch(books, i, toSearch);
					System.out.println(books[index]);
				}
			}
			
			catch (BookNotFoundException e) {
				System.out.println(e);
			}
		}
		
		input.close();
		keyboard.close();
	}
}