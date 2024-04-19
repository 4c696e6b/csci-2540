package activity5;
import java.util.Scanner;
public class ExceptionPractice {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		try {
			System.out.print("enter a positive number: ");
			int in = keyboard.nextInt();
			
			if (in < 0)
				throw new NegativeNumberException();
			
			else {
				double out = Math.sqrt(in);
				System.out.println("the square root of " + in + " is: " + out);
			}
		}
		
		catch (NegativeNumberException e) {
			System.out.println(e);
			keyboard.close();
			System.exit(1);
		
		keyboard.close();
		}
	}
}
