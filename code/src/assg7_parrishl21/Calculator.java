/**
 * @author Link Parrish
 * 
 * defines the calculator class, can convert infix to postfix and can calculate postfix expressions
 */
package assg7_parrishl21;

import java.util.Stack;

public class Calculator {
	
	String inExp = null;
	String postExp = null;

	/**
	 * 1 parameter constructor
	 * @param inExp the infix expression
	 */
	public Calculator(String inExp) {
		this.inExp = inExp;
	}
	
	/**
	 * returns the infix expression
	 * @return the infix expression
	 */
	public String toString() {
		return inExp;
	}
	
	/**
	 * converts the infix expression to postfix
	 * @return true if the conversion was successful, otherwise false
	 * @throws IllegalStateException throws if there are an imbalance of parentheses
	 */
	public boolean convertPostFix() throws IllegalStateException {

		Stack<Character> s = new Stack<Character>();
		boolean bal = true;
		char c;
		
		// checks for parentheses imbalance
		for (int i = 0; bal && i < inExp.length(); i++) {
			
			c = inExp.charAt(i);
			
			if (c == '(')
				s.push('(');
			
			else if (c == ')') {
				
				if (!s.isEmpty())
					s.pop();
				
				else
					bal = false;
			}	
		}
		
		if (!(bal && s.isEmpty()))
			throw new IllegalStateException("unbalanced parentheses");
		
		postExp = "";
		s = new Stack<Character>();
		
		// loop to convert to postfix
		for (int i = 0; i < inExp.length(); i++) {
			
			c = inExp.charAt(i);
			
			switch (c) {
			
			// operand case
			case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
				
				postExp += c;
				
				// keeps looking at the next character until we have the entire number
				while (i < inExp.length() - 1 && Character.isDigit(inExp.charAt(i+1)))
					postExp += inExp.charAt(++i);
				
				postExp += ' ';
				break;

			// open parentheses case
			case '(':
				
				s.push(c);
				break;
			
			// close parentheses case
			case ')':
				
				// pops all operators until we hit the open parentheses
				while (s.peek() != '(') 
					postExp = postExp + s.pop() + ' ';
				
				s.pop();
				break;

			// operator case
			case '+', '-', '*', '/':
				
				// pops all operators with higher precedence than the current operator
				while (!s.isEmpty() && s.peek() != '(' && precedence(c) <= precedence(s.peek()))
					postExp = postExp + s.pop() + ' ';
				s.push(c);
				break;
			}
		}
		
		// pops the rest of the operators
		while (!s.isEmpty())
			postExp = postExp + s.pop() + ' ';
		return true;
	}
	
	/**
	 * returns the postfix expression
	 * @return the postfix expression
	 * @throws IllegalStateException throws if infix has not been converted to postfix yet
	 */
	public String getPostFix() throws IllegalStateException {
		if (postExp == null)
			throw new IllegalStateException("Error: infix not converted to postfix");
		
		return postExp;
	}
	
	/**
	 * calculates the postfix expression
	 * @return returns the result of the calculation
	 * @throws IllegalStateException throws if infix has not been converted to postfix yet
	 */
	public int evaluate() throws IllegalStateException {
		
		if (postExp == null)
			throw new IllegalStateException("Error: infix not converted to postfix");
		
		Stack<Integer> s = new Stack<Integer>();
		char c;
		String x;
		int n1, n2;
		
		// loop to calculate the expression
		for (int i = 0; i < postExp.length(); i++) {
			
			c = postExp.charAt(i);
			x = "";
			
			switch (c) {
			
			// operand case
			case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
				
				x += c;
				
				// keeps looking at the next character until we have the entire number
				while (postExp.charAt(i+1) != ' ')
					x += postExp.charAt(++i);
				
				s.push(Integer.parseInt(x));
				break;
			
			// operator cases
				
			case '+':
				n2 = s.pop();
				n1 = s.pop();
				s.push(n1 + n2);
				break;
				
			case '-':
				n2 = s.pop();
				n1 = s.pop();
				s.push(n1 - n2);
				break;
			
			case '*':
				n2 = s.pop();
				n1 = s.pop();
				s.push(n1 * n2);
				break;
				
			case '/':
				n2 = s.pop();
				n1 = s.pop();
				s.push(n1 / n2);
				break;

			}
		}
		return s.pop();
	}
	
	/**
	 * gets the precedence of an operator
	 * @param c the operator
	 * @return the precedence of the operator given, or -1 if invalid operator
	 */
	private static int precedence(char c) {
		switch (c) {
		
		case '+', '-':
			return 0;
			
		case '*', '/':
			return 1;

		case '(', ')':
			return 2;
		
		default:
			return -1;
		}
	}
}
