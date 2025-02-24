import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(sc.nextLine());
		String[] commands = new String[n];
		for (int i = 0; i < n; i++) {
			commands[i] = sc.nextLine();
		}

		for (String command : commands) {
			String[] split = command.split(" ");

			switch (split[0]) {
				case "push":
					stack.push(Integer.parseInt(split[1]));
					break;
				case "pop":
					System.out.println(stack.pop());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println(stack.empty() ? "1" : "0");
					break;
				case "top":
					System.out.println(stack.peek());
					break;
			}
		}
	}
}
