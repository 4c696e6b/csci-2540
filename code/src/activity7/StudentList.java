/**
 * defines the student list object, custom array list for the student object
 * @author Link Parrish
 */
package activity7;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class StudentList implements StudentListInterface {
	
	private ArrayList<Student> roster;
	private String filename;
	private boolean change;
	
	/**
	 * Default constructor
	 */
	public StudentList() {
		this.roster = new ArrayList<Student>();
		this.filename = null;
		this.change = false;
	}
	
	/**
	 * loads the students from the file to the array list
	 * @param filename the of the input file
	 */
	public void loadData(String filename) {
		
		Scanner in = null;
		this.filename = filename;
		
		try {
			in = new Scanner(new File(this.filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error: file '" + filename + "' not found");
			System.exit(1);
		}
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			
			if (line.indexOf(',') != -1) {
				String[] temp = line.split(",", 4);
				this.addStudent(temp[0], temp[1], temp[2], temp[3]);
			}
		}
		in.close();
	}
	
	/**
	 * prints all of the students in the roster
	 */
	public void displayRoster() {
		for (int i = 0; i < roster.size(); i++) {
				System.out.println(roster.get(i));
		}
	}

	/**
	 * searches for a student of a certain id
	 * @param id the id of the student to search for
	 * @return the student object with the matching id
	 */
	public Student searchForStudent(String id) {
		for (int i = 0; i < roster.size(); i++) {
			if (roster.get(i).getId().equals(id)) 
				return roster.get(i);
		}
		
		return null;
	}
	
	/**
	 * adds a student to the roster
	 * @param id the id of the student
	 * @param name the name of the student
	 * @param standing the standing of the student
	 * @param major the major of the student
	 * @return true if the student was added, otherwise false
	 */
	public boolean addStudent(String id, String name, String standing, String major) {
		
		if (this.searchForStudent(id) != null) {
			System.out.println("Error: id '" + id + "' already exists in roster");
			return false;
		}
		
		else {
			Student temp = new Student(id, name, standing, major);
			roster.add(temp);
			this.change = true;
			return true;
		}
	}
	
	/**
	 * removes a student from the roster with the matching id
	 * @param id the id of the student to remove
	 * @return true if the student was removed, otherwise false
	 */
	public boolean removeStudent(String id) {
		for (int i = 0; i < roster.size(); i++) {
			if (roster.get(i).getId().equals(id)) {
				roster.remove(i);
				this.change = true;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * searches for students by major
	 * @param major the major to search for
	 * @return a list of the students with the matching major
	 */
	public ArrayList<Student> getStudentsByMajor(String major) {
		
		ArrayList<Student> majorRoster = new ArrayList<Student>();
		
		for (int i = 0; i < roster.size(); i++) {
			if (roster.get(i).getMajor().equals(major)) {
				majorRoster.add(roster.get(i));
			}
		}
		return majorRoster;
	}
	
	/**
	 * sorts the roster
	 */
	public void sort() {
		Collections.sort(roster);
		this.change = true;
	}
	
	/**
	 * saves the roster to the output file if the roster has been changed
	 */
	public void save() {
		
		PrintWriter out = null;
		
		if (change) {
			try {
				out = new PrintWriter(this.filename);
	        }
			
			catch (IOException e) {
				System.out.println("Error: file '" + this.filename + "' unable to open");
	            System.exit(1);
			}
			
			for (int i = 0; i < roster.size(); i++) {
				String id = roster.get(i).getId();
				String name = roster.get(i).getName();
				String standing = roster.get(i).getStanding();
				String major = roster.get(i).getMajor();
				out.println(id + "," + name + "," + standing + "," + major);
			}
			out.close();
			this.change = false;
		}	
	}
}
