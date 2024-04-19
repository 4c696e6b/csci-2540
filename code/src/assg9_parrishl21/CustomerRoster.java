/**
 * defines the customer roster, a binary search tree of customers
 * @author Link Parrish
 */
package assg9_parrishl21;

import java.io.*;

public class CustomerRoster {
	
	private BinarySearchTree<Customer, String> tree = null;
	
	/**
	 * the default constructor
	 */
	public CustomerRoster() {
		tree = new BinarySearchTree<Customer, String>();
	}
	
	/**
	 * adds a customer object to the binary search tree
	 * @param c
	 */
	public void add(Customer c) {
		tree.insert(c);
	}
	
	/**
	 * searches for a customer in the binary search tree
	 * @param id the id to search for
	 * @return the customer with the matching id, or null if none is found
	 */
	public Customer get(String id) {
		return tree.retrieve(id);
	}
	
	/**
	 * removes a customer from the search tree
	 * @param id the id of the customer to remove
	 */
	public void remove(String id) {
		tree.delete(id);
	}
	
	/**
	 * displays the roster in order
	 */
	public void display() {
		
		TreeIterator<Customer> iter = new TreeIterator<Customer>(tree);
		iter.setInorder();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	/**
	 * saves the roster to a file
	 * @param filename the filename to save to
	 */
	public void save(String filename) {
		
		PrintWriter out = null;
		
		// try catch for opening the output file
		try {
			out = new PrintWriter(new File(filename));
			}	
		
		catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		TreeIterator<Customer> iter = new TreeIterator<Customer>(tree);
		iter.setInorder();
		
		// while loop to write each customer to the output file
		while (iter.hasNext()) {
			out.println(iter.next());
		}
		
		out.close();
	}
}
