import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int ans = 0;
	static int time = 0;
	static int[][] grid;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		while (true) {
			init();
			push(0, 0);
			int lastMeltIce = bfs();
			if (lastMeltIce == 0)
				break;

			time++;
			ans = lastMeltIce;
		}

		System.out.println(time + " " + ans);
	}

	public static void push(int row, int col) {
		visited[row][col] = true;
		queue.add(new Pair(row, col));
	}

	public static int bfs() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];

				if (canGo(nextRow, nextCol)) {
					visited[nextRow][nextCol] = true;
					if (grid[nextRow][nextCol] == 1) {
						grid[nextRow][nextCol] = 0;
						cnt++;
					} else {
						queue.add(new Pair(nextRow, nextCol));
					}
				}
			}
		}

		return cnt;
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > m - 1);
	}

	public static void init() {
		if (visited == null) {
			visited = new boolean[n][m];
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static class Pair {
		public int row;
		public int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}