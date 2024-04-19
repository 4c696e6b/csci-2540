/**
 * @author Link Parrish
 * @author Donald McLaughlin
 */
package activity13;

import java.util.*;
import java.io.*;

public class MapPractice {
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		Scanner in = null;
		String filename = "activity13_input.txt";
		String line;
		String[] lineArgs;
		int action;
		String code, city;
		
		
		try {
			in = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e);
			kb.close();
			System.exit(1);
		}
		
		HashMap<String, String> airports = new HashMap<String, String>();
		
		while (in.hasNextLine()) {
			line = in.nextLine();
			lineArgs = line.split("\t");
			
			airports.put(lineArgs[0], lineArgs[1]);
		}
		
		do {
			System.out.println("1. Display all airports");
			System.out.println("2. Add airport");
			System.out.println("3. search for airport");
			System.out.println("4. Exit");
			System.out.print("Enter an option from the menu above: ");
			action = kb.nextInt();
			kb.nextLine();
			
			switch (action) {
			
			case 1:
			    Set<Map.Entry<String, String>> airportSet = airports.entrySet();
			    Iterator<Map.Entry<String, String>> iter = airportSet.iterator();
			    
			    while (iter.hasNext()) {
			    	Map.Entry<String,String> i = iter.next();
			    	System.out.println(i.getKey() + "\t" + i.getValue());
			    }
			    System.out.println("press ENTER to continue:");
				kb.nextLine();
			    break;
				
				
			case 2:
				System.out.print("Enter the new airport code: ");
				code = kb.nextLine();
				
				if (airports.get(code) != null)
					System.out.println("Error: code already exists");
				
				else {
					System.out.print("Enter the new city: ");
					city = kb.nextLine();
					
					airports.put(code, city);
				}
				System.out.println("press ENTER to continue:");
				kb.nextLine();
				break;
				
			case 3:
				System.out.print("Enter the airport code to search for: ");
				code = kb.nextLine();
				
				if (airports.get(code) == null)
					System.out.println("Error: code does not exists");
				
				else
					System.out.println(code + "\t" + airports.get(code));
				
				System.out.println("press ENTER to continue:");
				kb.nextLine();
			}
			
		} while (action != 4);
		
		in.close();
		kb.close();
	}
}
