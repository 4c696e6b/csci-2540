/**
 * @author Link Parrish
 * defines a book already exists exception, throws a message stating that the book already exists in the catalog
 */
package assg4_parrishl21;

@SuppressWarnings("serial")
public class BookIdAlreadyExistException extends Exception {
	
	/**
	 * default constructor
	 */
	public BookIdAlreadyExistException() {
		super("Error: book already exists in catalog");
	}

	/**
	 * 1 parameter constructor
	 * @param id the id that has a duplicate
	 */
	public BookIdAlreadyExistException(String id) {
		super("Error: book with id: '" + id + "' already exists");
	}
}
