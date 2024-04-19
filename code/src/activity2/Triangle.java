package activity2;

import java.util.Scanner;

public class Triangle {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the size for the triangle: ");
		int input = keyboard.nextInt();
		System.out.println();
		printTriangle(input);
		keyboard.close();
	}

	static void printLine(int length) {
	for (int i = 0; i < length; i++) System.out.print("*");
	System.out.println();
	}

	static void printTriangle(int size) {
		for (int i = 1; i < size; i++) printLine(i);
		for (int i = size; i > 0; i--) printLine(i);
	}
}