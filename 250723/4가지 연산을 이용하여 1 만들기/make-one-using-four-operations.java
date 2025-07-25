import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] visited = new boolean[2000000];
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
		visited[num] = true;
	}

	public static int bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			if (currV.num == 1)
				return currV.step;

			for (int i = 0; i < 4; i++) {
				int nextStep = currV.step + 1;
				int nextNum = currV.num;
				switch (i) {
					case 0:
						nextNum--;
						break;
					case 1:
						nextNum++;
						break;
					case 2:
						if (currV.num % 2 == 0) nextNum /= 2;
						break;
					default:
						if (currV.num % 3 == 0) nextNum /= 3;
				}

				if (!visited[nextNum])
					push(nextStep, nextNum);
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