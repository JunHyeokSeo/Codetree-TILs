import java.util.Scanner;
public class Main {
	public static int n;
	public static int m;
	public static int[][] grid;
	public static int[] x = {0, 1};
	public static int[] y = {1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		if (grid[n - 1][m - 2] == 0 && grid[n - 2][m - 1] == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		dfs(0, 0);
		System.out.println(0);
	}

	public static void dfs(int row, int col) {
		if (row == n - 1 && col == m - 1) {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 0; i < 2; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(nextRow, nextCol)) {
				dfs(nextRow, nextCol);
			}
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		return grid[row][col] != 0;
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > m - 1);
	}
}