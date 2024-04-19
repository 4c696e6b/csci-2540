package counter;

public class StepCounter extends Counter {
	
	private int stepBy;
	
	public StepCounter(int step) {
		super();
		stepBy = step;
	}
	
	public StepCounter(int startVal, int step) {
		super(startVal);
		stepBy = step;		
	}
	
	public void increment() {
		for (int x = 0; x < stepBy; x++)
			super.increment();
		//throw new ArithmeticException();
	}
	
	public void decrement() {
		for (int x = 0; x < stepBy; x++)
			super.decrement();
	}
}
