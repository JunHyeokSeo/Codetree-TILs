import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();

		String str = sc.nextLine();
		String[] split = str.split("");
		for (String s : split) {
			if (s.equals("(")) {
				stack.push("(");
			} else {
				if (stack.empty()) {
					System.out.println("No");
					return;
				}
				stack.pop();
			}
		}

		if (stack.empty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
