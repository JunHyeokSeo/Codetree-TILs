import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int k;
	static int cnt = 0;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;

			if (!canGo(row, col))
				continue;
			
			queue.add(new Pair(row, col));
			visited[row][col] = true;
			cnt++;
			bfs();
		}

		System.out.println(cnt);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];

				if (canGo(nextRow, nextCol)) {
					visited[nextRow][nextCol] = true;
					queue.add(new Pair(nextRow, nextCol));
					cnt++;
				}
			}
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] == 1)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	public static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}