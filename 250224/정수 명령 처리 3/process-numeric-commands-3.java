import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> dq = new ArrayDeque<>();

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] cmd = sc.nextLine().split(" ");


			switch (cmd[0]) {
				case "push_front":
					dq.addFirst(Integer.parseInt(cmd[1]));
					break;
				case "push_back":
					dq.addLast(Integer.parseInt(cmd[1]));
					break;
				case "pop_front":
					System.out.println(dq.pollFirst());
					break;
				case "pop_back":
					System.out.println(dq.pollLast());
					break;
				case "size":
					System.out.println(dq.size());
					break;
				case "empty":
					System.out.println(dq.isEmpty() ? 1 : 0);
					break;
				case "front":
					System.out.println(dq.peekFirst());
					break;
				case "back":
					System.out.println(dq.peekLast());
					break;
			}
		}
	}
}
