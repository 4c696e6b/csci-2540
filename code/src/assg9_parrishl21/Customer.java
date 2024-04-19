/**
 * defines the Customer class
 * a Customer has a Keyed item ID, a name, and a phone number
 * @author Link Parrish
 */
package assg9_parrishl21;

public class Customer extends KeyedItem<String>{
	
	private String name, phone;
	
	/**
	 * 3 parameter constructor
	 * @param id the keyed item id
	 * @param name the customer name
	 * @param phone the customer phone number
	 */
	public Customer(String id, String name, String phone) {
		super(id);
		this.name = name;
		this.phone = phone;
	}
	
	/**
	 * changes the customer name
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * changes the customer phone number
	 * @param phone the new phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * returns the id, name, and phone number as a string separated by tabs
	 * @return the id name and phone number in a string
	 */
	public String toString() {
		return this.getKey() + "\t" + this.name + "\t" + this.phone;
	}

}
