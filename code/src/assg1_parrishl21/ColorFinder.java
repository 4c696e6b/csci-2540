/*
 * Link Parrish
 */

package assg1_parrishl21;

import java.util.Scanner;

public class ColorFinder {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a sentence: ");	
		String input = keyboard.nextLine();
		input = input.toLowerCase();
		
		
		// checks if the word 'red', 'green', or 'blue' is in the string
		if (input.indexOf("red") != -1 || input.indexOf("green") != -1 || input.indexOf("blue") != -1)
			System.out.println("Additive Primary Color Found");
		
		// checks if the word 'cyan', 'green', or 'blue' is in the string
		else if (input.indexOf("cyan") != -1 || input.indexOf("magenta") != -1 || input.indexOf("yellow") != -1)
			System.out.println("Subtractive Primary Color Found");
		
		else
			System.out.println("No Primary Colors Found");
		
		keyboard.close();
	}
}
