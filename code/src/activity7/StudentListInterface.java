/**
 * interface definition for the student list
 * @author Link Parrish
 */

package activity7;

import java.util.ArrayList;

interface StudentListInterface {
	/**
	 * loads the students from the file to the array list
	 * @param filename the of the input file
	 */
	public void loadData(String filename);
	
	/**
	 * prints all of the students in the roster
	 */
	public void displayRoster();
	
	/**
	 * searches for a student of a certain id
	 * @param id the id of the student to search for
	 * @return the student object with the matching id
	 */
	public Student searchForStudent(String id);
	
	/**
	 * adds a student to the roster
	 * @param id the id of the student
	 * @param name the name of the student
	 * @param standing the standing of the student
	 * @param major the major of the student
	 * @return true if the student was added, otherwise false
	 */
	public boolean addStudent(String id, String name, String standing, String major);
	
	/**
	 * removes a student from the roster with the matching id
	 * @param id the id of the student to remove
	 * @return true if the student was removed, otherwise false
	 */
	public boolean removeStudent(String id);
	
	/**
	 * searches for students by major
	 * @param major the major to search for
	 * @return a list of the students with the matching major
	 */
	public ArrayList<Student> getStudentsByMajor(String major);
	
	/**
	 * sorts the roster
	 */
	public void sort();
	
	/**
	 * saves the roster to the output file if the roster has been changed
	 */
	public void save();
}
