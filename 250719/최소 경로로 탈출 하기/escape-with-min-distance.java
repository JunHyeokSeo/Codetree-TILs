import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static int[][] step;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		step = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		push(0, 0, 0);
		bfs();
		System.out.println(step[n - 1][m - 1] == 0 ? -1 : step[n - 1][m - 1]);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newRow = currV.row + y[i];
				int newCol = currV.col + x[i];
				if (canGo(newRow, newCol))
					push(newRow,  newCol, step[currV.row][currV.col] + 1);
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

	public static void push(int row, int col, int stepNum) {
		queue.add(new Pair(row, col));
		step[row][col] = stepNum;
		visited[row][col] = true;
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