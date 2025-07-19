import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int r1;
	static int c1;
	static int r2;
	static int c2;
	static boolean[][] visited;
	static int[][] step;
	static int[] x = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] y = {-2, -1, 1, 2, 2, 1, -1, -2};
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r1 = sc.nextInt() - 1;
		c1 = sc.nextInt() - 1;
		r2 = sc.nextInt() - 1;
		c2 = sc.nextInt() - 1;
		visited = new boolean[n][n];
		step = new int[n][n];
		visited[r1][c1] = true;
		queue.add(new Pair(c1, r1));
		bfs();
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			if (currV.y == r2 && currV.x == c2) {
				System.out.println(step[r2][c2]);
				return;
			}

			for (int i = 0; i < x.length; i++) {
				int nextY = currV.y + y[i];
				int nextX = currV.x + x[i];

				if (nextY < 0 || nextY > n - 1 || nextX < 0 || nextX > n - 1)
					continue;
				if (visited[nextY][nextX])
					continue;

				queue.add(new Pair(nextX, nextY));
				visited[nextY][nextX] = true;
				step[nextY][nextX] = step[currV.y][currV.x] + 1;
			}
		}
		System.out.println(-1);
	}

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}