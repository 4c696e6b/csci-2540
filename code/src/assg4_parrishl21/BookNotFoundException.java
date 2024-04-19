/**
 * @author Link Parrish
 * defines a book not found exceptions, throws a message that says the book it not found
 */
package assg4_parrishl21;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {

	/**
	 * the default constructor
	 */
	public BookNotFoundException() {
		super("Error: book not found");
	}
	
	/**
	 * 1 parameter constructor
	 * @param id  the id of the book not found
	 */
	public BookNotFoundException(String id) {
		super("Error: book id: '" + id + "' not found");
	}
}
