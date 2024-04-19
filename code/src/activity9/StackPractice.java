package activity9;

import java.util.Stack;
import java.util.Scanner;

public class StackPractice {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("enter a string: ");
		String str = in.nextLine();
		
		System.out.println("Reversed by Stack: " + strRevStack(str));
		System.out.println("Reversed by Iterative: " + strRevIterative(str));
		System.out.println("Reversed by Recursive: " + strRevRecursive(str));
		in.close();
	}
	
	public static String strRevStack(String s) {
		Stack<Character> stack = new Stack<Character>();
		String result = "";
		
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		
		while (!stack.empty()) {
			result += stack.pop();
		}
		
		return result;
	}
	
	public static String strRevIterative(String s) {
		
		String result = "";
		
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		
		return result;
	}
	
	public static String strRevRecursive(String s) {
		
		if (s.length() == 0 || s == null)
			return s;
		
		else {
			return s.charAt(s.length()-1) + strRevRecursive(s.substring(0, s.length() - 1));
		}
	}
}
