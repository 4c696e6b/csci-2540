/**
 * @author Link Parrish
 * uses the Calculator class to convert user inputed infix to postfix
 */
package assg7_parrishl21;

import java.util.Scanner;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		Calculator x;
		char again;
		Scanner in = new Scanner(System.in);
		
		do {
			// get the users infix
			System.out.print("Enter an Infix Expression: ");
			x = new Calculator(in.nextLine());
			
			try {
				// convert and display the postfix and value
				x.convertPostFix();
				System.out.println("Converted to Postfix: " + x.getPostFix());
				System.out.println("Postfix Evaluated: " + x.evaluate());
			}
			
			// catch all errors
			catch (IllegalStateException e) {
				System.out.println(e);
			}
			
			// check if the user wants to evaluate another infix expression
			System.out.print("\nCalculate Another Expression (y/n): ");
			again = in.nextLine().toLowerCase().charAt(0);
			
		} while (again == 'y');
	}
}
