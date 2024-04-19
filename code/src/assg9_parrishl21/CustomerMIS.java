package assg9_parrishl21;

import java.util.*;
import java.io.*;

public class CustomerMIS {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		Scanner in = null;
		
		String filename = "assg9_CustomerRoster.txt";
		String line, id, name, phone = null;
		String lineArgs[] = null;
		
		CustomerRoster roster = new CustomerRoster();
		Customer c = null;
		
		int action;
		
		// try catch to open the input file
		try {
			in = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		// while loop to add all the customers to the roster
		while (in.hasNextLine()) {
			line = in.nextLine();
			lineArgs = line.split("\t");
			roster.add(new Customer(lineArgs[0], lineArgs[1], lineArgs[2]));
		}
		
		// do while for the main program
		do {
			// prints the menu
			System.out.println("1. Display the Roster");
			System.out.println("2. Add a Customer");
			System.out.println("3. Remove a Customer");
			System.out.println("4. Search for a Customer");
			System.out.println("5. Update a Customer");
			System.out.println("6. Save and Exit");
			System.out.print("Enter an option from the menu above: ");
			
			action = kb.nextInt();
			kb.nextLine();
			
			// switch statement for each action
			switch (action) {
			
			// display case
			case 1:
				roster.display();
				System.out.println("Press [ENTER] to continue:");
				kb.nextLine();
				break;
			
			// add new customer case
			case 2:
				System.out.print("Enter the ID of the new customer: ");
				id = kb.nextLine();
				c = roster.get(id);
				
				// checks to make sure the id doesn't already exist
				if (c != null)
					System.out.println("Error: ID already exists");
				
				// adds the new customer to the roster
				else {
					System.out.print("Enter the name of the new customer: ");
					name = kb.nextLine();
					System.out.print("Enter the phone number of the new customer: ");
					phone = kb.nextLine();
					
					roster.add(new Customer(id, name, phone));
					System.out.println("Customer added!");
				}
				
				System.out.println("Press [ENTER] to continue:");
				kb.nextLine();
				break;

			// remove customer case
			case 3:
				System.out.print("Enter the ID of the customer to remove: ");
				id = kb.nextLine();
				c = roster.get(id);
				
				// checks to make sure the id exists
				if (c == null)
					System.out.println("Error: ID does not exist");
				
				// removes the customer
				else {
					roster.remove(id);
					System.out.println("Customer removed!");
				}
				
				System.out.println("Press [ENTER] to continue:");
				kb.nextLine();
				break;
			
			// search case
			case 4:
				System.out.print("Enter the ID of the customer to search for: ");
				id = kb.nextLine();
				c = roster.get(id);
				
				// checks to make sure the id exists
				if (c == null)
					System.out.println("Error: ID does not exist");
				
				// prints the search result
				else
					System.out.println(c);
					
				System.out.println("Press [ENTER] to continue:");
				kb.nextLine();
				break;
			
			// edit case
			case 5:
				System.out.print("Enter the ID of the customer to edit: ");
				id = kb.nextLine();
				c = roster.get(id);
				
				// checks that the id exists
				if (c == null)
					System.out.println("Error: ID does not exist");
				
				// changes the name and phone number
				else {
					System.out.print("Enter the new name: ");
					name = kb.nextLine();
					c.setName(name);
					
					System.out.print("Enter the new phone number: ");
					phone = kb.nextLine();
					c.setPhone(phone);
					
					System.out.println("Edit Successful!");
				}
				
				System.out.println("Press [ENTER] to continue:");
				kb.nextLine();
				break;
				
			// save case
			case 6:
				roster.save(filename);
				System.out.println("Save successful!");
				break;
			}
			
		} while (action != 6);
		
		in.close();
		kb.close();
	}
}
