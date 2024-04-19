package activity6_parrishl21;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCourse {

    public Course c1, c2;
    
    @Before
    public void setUp() {
        c1 = new Course("001", "Java");
        c2 = new Course("002", "C++", 4);
    }
    
    @Test
    public void testTwoParamConstructor() {
        assertEquals("c1 course number:" , "001", c1.getCourseNo());
        assertEquals("c1 course name:", "Java", c1.getTitle());
        assertEquals("c1 credit hours:", 3, c1.getCredit());
    }
    
    @Test
    public void testThreeParamConstructor() {
        assertEquals("c2 course number:" , "002", c2.getCourseNo());
        assertEquals("c2 course name:", "C++", c2.getTitle());
        assertEquals("c2 credit hours:", 4, c2.getCredit());
    }
    
    @Test
    public void testSetters() {
        c1.setTitle("Python");
        c1.setCredit(2);
        assertEquals("c1 new course name:", "Python", c1.getTitle());
        assertEquals("c1 new credit hours:", 2, c1.getCredit());
    }
    
    @Test
    public void testToString() {
        assertEquals("c1 toString:", "001 - Java (3)", c1.toString());
        assertEquals("c2 toString:", "002 - C++ (4)", c2.toString());
    }
}