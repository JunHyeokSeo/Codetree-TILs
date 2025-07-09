import java.util.Scanner;

public class Main {
	static int n;
	static int exploredBlockCnt = 0;
	static int biggestBlockSize = 0;
	static int currBlockSize;
	static int[][] grid;
	static boolean[][] visited;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (!canGo(row, col))
					continue;

				currBlockSize = 1;
				visited[row][col] = true;
				dfs(grid[row][col], row, col);

				biggestBlockSize = Math.max(biggestBlockSize, currBlockSize);
				if (currBlockSize >= 4)
					exploredBlockCnt++;
			}
		}

		System.out.println(exploredBlockCnt + " " + biggestBlockSize);
	}

	public static void dfs(int currNum, int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(nextRow, nextCol) && grid[nextRow][nextCol] == currNum) {
				currBlockSize++;
				visited[nextRow][nextCol] = true;
				dfs(currNum, nextRow, nextCol);
			}
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}
}