import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int k;
	static int r;
	static int c;
	static int strNum;
	static int currNum = 0;
	static boolean moved = false;
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
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;
		for (int i = 0; i < k; i++) {
			moved = false;
			visited = new boolean[n][n];
			visited[r][c] = true;
			currNum = 0;
			strNum = grid[r][c];
			queue.add(new Pair(r, c));
			bfs();

			if (!moved)
				break;
		}

		System.out.println((r + 1) + " " + (c + 1));
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];

				if (canGo(nextRow, nextCol)) {
					queue.add(new Pair(nextRow, nextCol));
					visited[currV.row][currV.col] = true;
					updateJumpPoint(nextRow, nextCol);
					moved = true;
				}
			}
		}
	}

	public static void updateJumpPoint(int jumpRow, int jumpCol) {
		int jumpNum = grid[jumpRow][jumpCol];

		if ((jumpNum > currNum) || (jumpNum == currNum && r > jumpRow) || (jumpNum == currNum && r == jumpRow && c > jumpCol)) {
			r = jumpRow;
			c = jumpCol;
			currNum = jumpNum;
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] >= strNum)
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