package counter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCounter {

	private Counter x, y;
	
	@Before
	public void setUp() {
		x = new Counter();
		y = new Counter(6);
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals("Counter value:", 0, x.getCounter());
	}
	
	@Test
	public void testOneParamConstructor() {
		assertEquals("Counter value:", 6, y.getCounter());
	}
	
	@Test
	public void testToString() {
		assertEquals("Counter value:", "0", x.toString());
		assertEquals("Counter value:", "6", y.toString());
	}
	
	@Test
	public void testIncrement() {
		x.increment();
		y.increment();
		assertEquals("Counter value:", 1, x.getCounter());
		assertEquals("Counter value:", 7, y.getCounter());
	}
	
	@Test
	public void testDecrement() {
		x.decrement();
		y.decrement();
		assertEquals("Counter value:", -1, x.getCounter());
		assertEquals("Counter value:", 5, y.getCounter());
	}
	
	@Test
	public void testResetAfterInc() {
		x.increment();
		y.increment();
		x.reset();
		y.reset();
		assertEquals("Counter value:", 0, x.getCounter());
		assertEquals("Counter value:", 6, y.getCounter());
	}
	
	@Test
	public void testResetAfterDec() {
		x.decrement();
		y.decrement();
		x.reset();
		y.reset();
		assertEquals("Counter value:", 0, x.getCounter());
		assertEquals("Counter value:", 6, y.getCounter());
	}
}
