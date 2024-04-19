/*
 * Link Parrish
 */

package assg1_parrishl21;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
	public static void main(String[] args) {
		
		int secret, input;
		int count = 0;
		boolean flag = false;
		
		Random generator = new Random(); 
		secret = generator.nextInt(100);
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Guess the number: ");
		
		while (!flag) {
		
			input = keyboard.nextInt();
			count++;
			
			if (input == secret) flag = true;
			else if (input > secret) System.out.print("Lower: ");
			else System.out.print("Higher: ");
		}
		
		if (count == 1) System.out.println("Wow, you got it first try!");
		else System.out.println("Correct! It took you " + count + " guesses.");
		
		keyboard.close();
	}
}
