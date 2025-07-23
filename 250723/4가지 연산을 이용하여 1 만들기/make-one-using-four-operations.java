import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		push(0, n);
		int step = bfs();
		System.out.println(step);
	}

	public static void push(int step, int num) {
		queue.add(new Pair(step, num));
	}

	public static int bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			if (currV.num == 1)
				return currV.step;

			if (currV.num < 1)
				continue;

			for (int i = 0; i < 4; i++) {
				switch (i) {
					case 0:
						push(currV.step + 1, currV.num - 1);
						break;
					case 1:
						push(currV.step + 1, currV.num + 1);
						break;
					case 2:
						if (currV.num % 2 == 0) push(currV.step + 1, currV.num / 2);
						break;
					case 3:
						if (currV.num % 3 == 0) push(currV.step + 1, currV.num / 3);
						break;
					default:
				}
			}
		}

		return 0;
	}

	public static class Pair {
		int step, num;

		public Pair(int step, int num) {
			this.step = step;
			this.num = num;
		}
	}
}