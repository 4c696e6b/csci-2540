package activity3;

public class CourseTest {
	public static void main(String args[]) {
		
		Course c1 = new Course("001", "Java");
		Course c2 = new Course("002", "C++", 4);
		
		System.out.println("Course 1: " + c1);
		System.out.println("Course 2: " + c2);
		
		c1.setTitle("Python");
		c1.setCredit(2);
		
		System.out.println("Course 1 No: " + c1.getCourseNo() + ", title: " + c1.getTitle() + ", credit: " + c1.getCredit());
		
		c1.printInfo();
		c2.printInfo();
		
	}
}