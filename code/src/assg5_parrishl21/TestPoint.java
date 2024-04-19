package assg5_parrishl21;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPoint {
	
	private Point p1, p2, p3, p4;
	
	@Before
	public void setUp() {
		p1 = new Point();
		p2 = new Point(1, 1);
		p3 = new Point(3, 4);
		p4 = new Point(1, 1);
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals("x coord value:", 0, p1.getXCoord());
		assertEquals("y coord value:", 0, p1.getYCoord());
	}
	
	@Test
	public void testTwoParamConstructor() {
		assertEquals("x coord value:", 1, p2.getXCoord());
		assertEquals("y coord value:", 1, p2.getYCoord());
	}
	
	@Test
	public void testSetMethods() {
		p1.setXCoord(2);
		p1.setYCoord(2);
		assertEquals("new x coord value:", 2, p1.getXCoord());
		assertEquals("new y coord value:", 2, p1.getYCoord());
	}
	
	@Test
	public void testToString() {
		assertEquals("Point coords:", "(0, 0)", p1.toString());
		assertEquals("Point coords:", "(1, 1)", p2.toString());
	}

	@Test
	public void testDistance() {
		assertEquals("distance from p1 to p2:", 5, p1.distance(p3), 0.1);
	}
	
	@Test
	public void testEquals() {
		assertTrue("p1 does not equal p2", !p1.equals(p2));
		assertTrue("p1 equals p4", p2.equals(p4));
	}
}
