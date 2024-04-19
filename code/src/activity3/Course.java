package activity3;

public class Course {

	private String courseNo;
	private String title;
	private int credit;
	
	/**
	 * Constructor with a given course number and title
	 * @param courseNo The given course number
	 * @param title The given title
	 */
	public Course(String courseNo, String title) {
		this(courseNo, title, 3);
	}
	
	/**
	 * Constructor wit ha given course number, title, and credit hours
	 * @param courseNo The given course number
	 * @param title The given title
	 * @param credit The given credit hours
	 */
	public Course(String courseNo, String title, int credit) {
		this.courseNo = courseNo;
		this.title = title;
		this.credit = credit;
	}
	
	/**
	 * Retrieves the course number 
	 * @return The course number
	 */
	public String getCourseNo() {
		return this.courseNo;
	}
	
	/**
	 * Retrieves the title
	 * @return The title
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * Retrieves the credit hours
	 * @return The value of credits hours
	 */
	public int getCredit() {
		return this.credit;
	}
	
	/**
	 * Modify the title
	 * @param title The new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Modify the value of credit hours
	 * @param credit The new value of credit hours
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	/**
	 * Returns a string with the course number, title and credit hours
	 * @return A string with the course number, title and credit hours
	 */
	public String toString() {
		return this.courseNo + " - " + this.title + " (" + this.credit + ")";
	}
	
	/**
	 * Prints the course number and title
	 */
	public void printInfo() {
		System.out.println(this.courseNo + " - " + this.title);
	}
}
