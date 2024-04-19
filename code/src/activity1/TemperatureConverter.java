package activity1;

import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {
		
		int f;
		double c;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a Tempature in Fahrenheit: ");
		
		f = keyboard.nextInt();
		c = (f - 32) * 5.0 / 9;
		
		System.out.println("The same Temperature in Celsius: " + c);
		keyboard.close();
	}
}
