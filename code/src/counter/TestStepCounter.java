package counter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStepCounter {

	private StepCounter x, y;
	
	@Before
	public void setUp() {
		x = new StepCounter(3);
		y = new StepCounter(6, 4);
	}
	
	@Test
	public void testOneParamConstructor() {
		assertEquals("Counter value:", 1, x.getCounter());
	}
	
	@Test
	public void testTwoParamConstructor() {
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
		assertEquals("Counter value:", 3, x.getCounter());
		assertEquals("Counter value:", 10, y.getCounter());
	}
	
	@Test
	public void testDecrement() {
		x.decrement();
		y.decrement();
		assertEquals("Counter value:", -3, x.getCounter());
		assertEquals("Counter value:", 2, y.getCounter());
	}
	
	@Test
	public void testReset() {
		x.increment();
		y.increment();
		x.reset();
		y.reset();
		assertEquals("Counter value:", 0, x.getCounter());
		assertEquals("Counter value:", 6, y.getCounter());
		
		x.decrement();
		y.decrement();
		x.reset();
		y.reset();
		assertEquals("Counter value:", 0, x.getCounter());
		assertEquals("Counter value:", 6, y.getCounter());
	}
	
}
