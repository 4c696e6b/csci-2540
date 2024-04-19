package activity4;

public class SpecialTopicCourseTest {

	public static void main(String[] args) {
		
		SpecialTopicCourse c1 = new SpecialTopicCourse("001", "Java", "Learning about OOP");
		SpecialTopicCourse c2 = new SpecialTopicCourse("002", "C++", 4, "Learning about complex data structures");
		Course c3 = new SpecialTopicCourse("001", "Java", "Learning about OOP");
		
		c2.setTopic("learning about cout statements");
		System.out.println(c2.getTopic());
		
		System.out.println(c1 + "\n" + c2 + "\n" + c3);
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
}
