package counter;

public class Counter {
	
	private int data;
	private int startVal;
	
	public Counter() {
		data = startVal = 0;
	}
	
	public Counter(int startVal) {
		data = this.startVal = startVal;
	}
	
	public void increment() {
		data++;
	}
	
	public void decrement() {
		data--;
	}
	
	public void reset() {
		data = startVal;
		//data = 0;                     //intentional reset error
	}
	
	public int getCounter() {
		return data;
	}
	
	public String toString() {
		return "" + getCounter();
	}
}
