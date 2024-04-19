package assg5_parrishl21;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestExtendedCircle {
	
	ExtendedCircle c1, c2, c3, c4, c5, c6;
	
	@Before
	public void setUp() {
		c1 = new ExtendedCircle();
		c2 = new ExtendedCircle(2.5);
		c3 = new ExtendedCircle(3, new Point(3, 3));
		c4 = new ExtendedCircle(4, new Point(8, 8));
		c6 = new ExtendedCircle(3, new Point(3, 3));
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals("c1 radius", 1, c1.getRadius(), 0.1);
		assertEquals("c1 center", new Point(0, 0), c1.getCenter());
	}
	
	@Test
	public void testOneParamConstructor() {
		assertEquals("c2 radius", 2.5, c2.getRadius(), 0.1);
		assertEquals("c3 center", new Point(0, 0), c2.getCenter());
	}
	
	@Test
	public void testTwoParamConstructor() {
		assertEquals("c3 radius", 3, c3.getRadius(), 0.1);
		assertEquals("c3 center", new Point(3, 3), c3.getCenter());
	}
	
	@Test
	public void testSetters() {
		c1.setRadius(2);
		c1.setCenter(new Point(1, 1));
		assertEquals("c1 radius", 2, c1.getRadius(), 0.1);
		assertEquals("c1 center", new Point(1, 1), c1.getCenter());
		
	}
	
	@Test
	public void testCompArea() {
		assertEquals("c4 area", 50.24, c4.compArea(), 0.1);
	}
	
	@Test
	public void testCompCircumference() {
		assertEquals("c4 circumference", 25.12, c4.compCircumference(), 0.1);
	}
	
	@Test
	public void testToString() {
		assertEquals("c1 toString", "Radius: 1.0\nCenter: (0, 0)", c1.toString());
	}
	
	@Test
	public void testPositionToCircle() {
		assertEquals("c4 in circle", 1, c4.positionToCircle(new Point(6, 6)));
		assertEquals("c4 on edge", 0, c4.positionToCircle(new Point(8, 4)));
		assertEquals("c4 outside circle", -1, c4.positionToCircle(new Point(0, 0)));
	}
	
	@Test
	public void testShift() {
		c5 = c1.shift(2, 2);
		assertEquals("c5 radius", 1, c5.getRadius(), 0.1);
		assertEquals("c5 center", new Point(2, 2), c5.getCenter());
	}
	
	@Test
	public void testScale() {
		c5 = c1.scale(2);
		assertEquals("c5 radius", 2, c5.getRadius(), 0.1);
		assertEquals("c5 center", new Point(0, 0), c5.getCenter());
	}
	
	@Test
	public void testOverlap() {
		assertTrue("c1 does not overlap c4", !c1.overlap(c4));
		assertTrue("c1 overlaps c2", c1.overlap(c2));
	}
	
	@Test
	public void testEquals() {
		assertTrue("c3 does not equal c4", !c3.equals(c4));
		assertTrue("c3 equals c6", c3.equals(c6));
	}
}
