import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, k;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static int[][] step;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		step = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();

				if (grid[i][j] == 2)
					push(i, j, 0);
			}
		}

		bfs();
		print();
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					System.out.print(step[i][j] + " ");
				else if (grid[i][j] == 0)
					System.out.print(-1 + " ");
				else
					System.out.print(-2 + " ");
			}
			System.out.println();
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];

				if (canGo(nextRow,  nextCol))
					push(nextRow, nextCol, step[currV.row][currV.col] + 1);
			}
		}
	}

	public static void push(int row, int col, int stepNum) {
		queue.add(new Pair(row, col));
		step[row][col] = stepNum;
		visited[row][col] = true;
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] != 1)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	public static class Pair {
		int row, col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}