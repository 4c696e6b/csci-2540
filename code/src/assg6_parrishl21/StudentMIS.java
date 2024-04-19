/**
 * uses the StudentList class to create a student roster
 * allows the user to make changes, and save it
 * @author Link Parrish
 */
package assg6_parrishl21;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentMIS {

	public static void main(String[] args) {
		
		int action;
		String id, name, standing, major;
		Student searchResult;
		StudentList sl = new StudentList();
		ArrayList<Student> majorRoster = new ArrayList<Student>();
		Scanner kb = new Scanner(System.in);
		
		sl.loadData("assg6_data.txt");
		
		System.out.println("1: Display the Roster");
		System.out.println("2: Search for Student by ID");
		System.out.println("3: Add a New Student");
		System.out.println("4: Remove a Student");
		System.out.println("5: Search for Student by Major");
		System.out.println("6: Sort and Save to File");
		System.out.println("7: Save to File");
		System.out.println("8: Exit");
		
		do {
			
			// get action
			System.out.print("\nEnter an Action from the Menu: ");
			action = kb.nextInt();
			kb.nextLine();
			
			switch (action) {
			
			// case 1, display the roster
			case 1:
				sl.displayRoster();
				break;
			
			// case 2, search for a student by id
			case 2:
				// get the id
				System.out.print("Enter an ID to Search for: ");
				id = kb.nextLine();
				
				// get the search result
				searchResult = sl.searchForStudent(id);
				
				// handles the search output
				if (searchResult != null)
					System.out.println(searchResult);
				else
					System.out.println("ID not found");
				break;
			
			// case 3, add a student
			case 3:
				// get the new id
				System.out.print("Enter the New ID: ");
				id = kb.nextLine();
				
				// checks if the id exists
				searchResult = sl.searchForStudent(id);
				
				// handles if the id exists
				if (searchResult != null)
					System.out.println("Error ID Already Exists");
				
				// gets the other info
				else {

					System.out.print("Enter the New Name: ");
					name = kb.nextLine();
					
					System.out.print("Enter the New Standing: ");
					standing = kb.nextLine();
					
					System.out.print("Enter the New Major: ");
					major = kb.nextLine();
					
					sl.addStudent(id, name, standing, major);

				}
				break;
				
			// case 4, remove a student
			case 4:
				// get the id
				System.out.print("Enter the ID of the Student to Remove: ");
				id = kb.nextLine();
				
				// search for the id
				searchResult = sl.searchForStudent(id);
				
				// removes if the id exists
				if (searchResult != null)
					sl.removeStudent(id);
				
				// handles if the id doesn't exist
				else
					System.out.println("Error ID does not Exist");
				
				break;
				
			// case 5, display all students of a certain major
			case 5:
				
				// get the major
				System.out.print("Enter the Major to search for: ");
				major = kb.nextLine();
				
				// get the students
				majorRoster = sl.getStudentsByMajor(major);
				
				// handles if no students have that major
				if (majorRoster.size() == 0)
					System.out.println("Error no Students of Major '" + major + "' Exist");
				
				// displays the students with the major
				else {
					for (int i = 0; i < majorRoster.size(); i++) {
						System.out.println(majorRoster.get(i));
					}
				}
				
				break;
				
			// case 6, save and sort
			case 6:
				sl.sort();
				sl.save();
				break;
			
			// case 7, save
			case 7:
				sl.save();
				break;
			}
					
		}  while(action != 8);
		
		sl.save();
		kb.close();
	}
}