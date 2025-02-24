import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> dq = new ArrayDeque<>();

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			dq.addLast(i);
		}

		while (dq.size() != 1) {
			dq.pollFirst();
			dq.addLast(dq.pollFirst());
		}

		System.out.println(dq.pollFirst());
	}
}
