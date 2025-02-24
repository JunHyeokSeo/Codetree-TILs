import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();

		int n = sc.nextInt();
		int k = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.peek());
				queue.poll();
			}

			System.out.print(queue.poll() + " ");
		}
	}
}
