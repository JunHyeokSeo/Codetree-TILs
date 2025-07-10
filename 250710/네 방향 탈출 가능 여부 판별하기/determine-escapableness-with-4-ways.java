import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		queue.add(new Pair(0, 0));
		visited[0][0] = true;
		bfs();

		System.out.println(visited[n - 1][m - 1] ? 1 : 0);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = p.row + y[i];
				int nextCol = p.col + x[i];
				if (canGo(nextRow, nextCol)) {
					queue.add(new Pair(nextRow, nextCol));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] == 0)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > m - 1);
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