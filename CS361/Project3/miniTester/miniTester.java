package fa.nfa;

import java.util.Stack;
import java.util.Vector;

public class miniTester {

	public static void main(String[] args) {


		Stack<Character> parenStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		Vector sandwichStorage = new Vector();

		//note that '|' represents or
		//check for '*' after every ')'
		String regEx = "((a|b)(a|b))*a";

		for (int i = 0; i < regEx.length(); i++) {

			if(regEx.charAt(i) == '(') {
				parenStack.push(regEx.charAt(i));
				indexStack.push(i);
			}

			if(regEx.charAt(i) == ')' && parenStack.peek().equals('(')) {
				String sandwich = regEx.substring(indexStack.peek(), i);
				parenStack.pop();
				indexStack.pop();
				System.out.println(sandwich);
			}
			
			else if(regEx.charAt(i) == ')') {
				parenStack.push(regEx.charAt(i));
				indexStack.push(i);
			}
			
		}

	}	

}
