import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String command = sc.nextLine();
			String[] split = command.split(" ");

			switch (split[0]) {
				case "push":
					queue.add(Integer.parseInt(split[0]));
					break;
				case "pop":
					System.out.println(queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					System.out.println(queue.isEmpty() ? 1 : 0);
					break;
				case "front":
					System.out.println(queue.peek());
					break;
			}
		}
	}
}
