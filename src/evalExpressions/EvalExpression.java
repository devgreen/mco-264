package evalExpressions;

import java.util.*;
import java.util.Stack;

public class EvalExpression {
	private Stack<String> opStack;

	public EvalExpression() {
		opStack = new Stack<String>();

	}

	public String PostFix(StringTokenizer infix) throws RuntimeException {
		String token;
		String topToken;
		char operator;
		StringBuffer postFixExp = new StringBuffer(); // contains PostFix
														// expression
		final String BLANK = " ";
		while (infix.hasMoreElements()) {
			token = infix.nextToken();
			if (token.matches("[\\+-/\\*()]")) {
				operator = token.charAt(0);
				// this is a mathematical operator or a parenthesis
				switch (operator) {
				case '(':
					opStack.push(token);
					break;
				case ')':
					for (;;) {
						try {
							topToken = opStack.pop();
							if (topToken.charAt(0) == '(')
								break;
							else {
								postFixExp.append(BLANK);
								postFixExp.append(topToken);
							}
						} catch (Exception e) {
							// doesn't have a matching open parenthesis
							throw new RuntimeException("invalid expression");

						}
					}
					break;

				case '+':
				case '-':
				case '*':
				case '/':
					for (;;) {
						char topTok;
						if (!opStack.empty())
							topTok = opStack.peek().charAt(0);
						else
							topTok = ' '; // set it to blank
						if (opStack.empty() || topTok == '(' || (operator == '*' || operator == '/')
								&& (topTok == '+' || topTok == '-')) {
							opStack.push(token);
							break;

						} else {
							topToken = opStack.pop();
							postFixExp.append(BLANK + topToken);

						}
					}
					break;
				}

			} else {
				// it is a number , just place it into the expression
				postFixExp.append(BLANK + token);

			}

		}
		while (!opStack.empty()) { // pop what is left in the operator stack
			topToken = opStack.pop();
			if (topToken.charAt(0) != '(') {
				postFixExp.append(BLANK + topToken);
			} else {
				// found an unmatched ( parenthesis
				throw new RuntimeException("*** Error in infix expression");

			}
		}
		System.out.println(postFixExp);
		return new String(postFixExp);

	}

	public Double evalPostFix(StringTokenizer postFixExp) {
		String token;
		while (postFixExp.hasMoreTokens()) {
			token = postFixExp.nextToken();
			if (token.matches("[\\+-/\\*]")) {
				switch (token) {
				case "+": {
					String token1 = opStack.pop();
					String token2 = opStack.pop();
					int value = Integer.parseInt(token2) + Integer.parseInt(token1);
					String value1 = Integer.toString(value);
					opStack.push(value1);

					break;
				}
				case "-": {
					String token1 = opStack.pop();
					String token2 = opStack.pop();
					int value = Integer.parseInt(token2) - Integer.parseInt(token1);
					String value1 = Integer.toString(value);
					opStack.push(value1);

					break;
				}

				case "*": {
					String token1 = opStack.pop();
					String token2 = opStack.pop();
					int value = Integer.parseInt(token2) * Integer.parseInt(token1);
					String value1 = Integer.toString(value);
					opStack.push(value1);

					break;
				}

				case "/": {
					String token1 = opStack.pop();
					String token2 = opStack.pop();
					int value = Integer.parseInt(token2) / Integer.parseInt(token1);
					String value1 = Integer.toString(value);
					opStack.push(value1);

					break;
				}
				}
			}

			else {
				opStack.push(token);
			}
		}

		return Double.parseDouble(opStack.pop());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		EvalExpression anExpression = new EvalExpression();
		Scanner console = new Scanner(System.in);
		String completeExpression;
		StringTokenizer expressionParts;
		Double value;
		System.out.println("Enter a complete algebraic expression");
		completeExpression = console.nextLine();
		expressionParts = new StringTokenizer(completeExpression);
		String postFixExp;
		postFixExp = anExpression.PostFix(expressionParts);
		// now evaluate the expression
		expressionParts = new StringTokenizer(postFixExp);
		value = anExpression.evalPostFix(expressionParts);
		System.out.println("expression = " + value);
		console.close();

	}
}
