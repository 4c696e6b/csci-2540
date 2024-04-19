package activity1;

import java.util.Scanner;

public class StringProcessing {

	public static void main(String[] args) {
		
		char first, last;
		String input, middle = new String();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a string at least 2 characters long: ");
		input = keyboard.nextLine();
		
		first = input.charAt(0);
		last = input.charAt(input.length() - 1);
		middle = input.substring(1, input.length() - 1);
		
		System.out.println("The First Character is: " + first);
		System.out.println("The Last Character is: " +last);
		System.out.println("The Middle Characters: " + middle);	
		keyboard.close();
	}
}
