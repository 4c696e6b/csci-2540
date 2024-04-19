/**
 * defines the student object, a student object contains an id, name, standing, and major
 * @author Link Parrish
 */
package assg6_parrishl21;

public class Student implements Comparable<Student> {
	
	private String id, name, standing, major;
	
	/**
	 * 4 parameter constructor
	 * @param id the id of the student
	 * @param name the name of the student
	 * @param standing the standing of the student
	 * @param major the major of the student
	 */
	public Student(String id, String name, String standing, String major) {
		this.id = id;
		this.name = name;
		this.standing = standing;
		this.major = major;
	}
	
	/**
	 * gets the student's id
	 * @return the student's id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * gets the student's name
	 * @return the student's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * gets the student's standing
	 * @return the student's standing
	 */
	public String getStanding() {
		return this.standing;
	}
	
	/**
	 * gets the student's major
	 * @return the student's major
	 */
	public String getMajor() {
		return this.major;
	}
	
	/**
	 * changes the student's major
	 * @param major the new major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * returns the student's info in a string
	 * @return the id name standing and major in a string
	 */
	public String toString() {
		return id + " - " + name + " - " + standing + " - " + major;
	}
	
	/**
	 * checks if a object is a student object, if so checks if they are the same
	 * @return true if the objects are the same, otherwise false
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Student) {
			Student temp = (Student)obj;
			return (this.id.equals(temp.id));
		}
		else
			return false;
	}
	
	/**
	 * compares two student objects based on their id's
	 * @return -1 if the student id is less, 0 if it is the same, and 1 if it is greater
	 */
	public int compareTo(Student s) {
		return this.id.compareTo(s.getId());
		}
}
