/**
 * @author Link Parrish
 * Defines a book object, a book has an id, title, isbn, author, and category
 */
package assg4_parrishl21;

public class Book {

	private String id, title, isbn, author;
	private char category;
	
	/**
	 * 5 parameter constructor
	 * @param id the book id
	 * @param title the book title
	 * @param isbn the book isbn number
	 * @param author the book author
	 * @param category the category, F for fiction, N for non-fiction
	 */
	public Book(String id, String title, String isbn, String author, char category) {
		
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
	}
	
	/**
	 * get the book id
	 * @return the book id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * get the book title
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * get the book isbn number
	 * @return the book isbn number
	 */
	public String getIsbn() {
		return this.isbn;
	}
	
	/**
	 * get the book author
	 * @return the book author
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * get the book category
	 * @return the book category
	 */
	public char getCategory() {
		return this.category;
	}
	
	/**
	 * returns the book's id, title, isbn, author, and category in a string
	 * @return the string
	 */
	@Override
	public String toString () {
		if (category == 'F')
			return id + ", " + title + ", " + isbn + ", " + author + ", Fiction";
		
		else
			return id + ", " + title + ", " + isbn + ", " + author + ", Non-Fiction";

	}
	
	/**
	 * searches for a book id in an array of books
	 * @param books the book array to search
	 * @param length the length of the array
	 * @param id the id to search for
	 * @return the index of the book with the matching id
	 * @throws BookNotFoundException thrown if the id cannot be found
	 */
	public static int bookSearch(Book[] books, int length, String id) throws BookNotFoundException {
		for (int i = 0; i < length; i++) {
			if (books[i].getId().equals(id)) {
				return i;
			}
		}
		throw new BookNotFoundException(id);
	}
}
