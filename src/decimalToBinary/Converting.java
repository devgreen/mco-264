package decimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class Converting {

	private Stack<Integer> stack;

	public Converting() {
		stack = new Stack<Integer>();
	}

	public Integer convert(Integer decimal) {
		StringBuilder binary = new StringBuilder();
		while (decimal > 0) {

			Integer remainder = decimal % 2;
			decimal = decimal / 2;
			stack.push(remainder);

		}
		while (stack.empty() != true) {
			binary.append(stack.pop().intValue());

			// System.out.print(stack.pop().intValue());

		}
		return Integer.parseInt(binary.toString());

	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("put in a number to convert");
		Integer input = keyboard.nextInt();
		Converting convert = new Converting();
		Integer results = convert.convert(input);
		System.out.println(results);
		keyboard.close();
	}

}
