import java.util.Scanner;
public class Main {
	static int[] x = {0, 0, 0, 0, 0, 0, -1, 1, -1, 1, -1, 1};
	static int[] y = {-2, -1, 1, 2, -1, 1, 0, 0, -1, -1, 1, 1};
	static int maxExploreCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[n][n];
		int bombCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int input = sc.nextInt();
				grid[i][j] = input;
				if (input == 1)
					bombCnt++;
			}
		}

		getCnt(bombCnt, 0, n, grid);
		System.out.println(maxExploreCnt);
	}


	public static void getCnt(int bombCnt, int depth, int n, int[][] grid) {
		if (depth == bombCnt) {
			int exploreCnt = 0;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (grid[row][col] < 0)
						exploreCnt++;
				}
			}

			maxExploreCnt = Math.max(maxExploreCnt, exploreCnt);
			return;
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (grid[row][col] != 1)
					continue;

				for (int bombKind = 0; bombKind < 3; bombKind++) {
					bomb(row, col, n, bombKind, grid);
					getCnt(bombCnt, depth + 1, n, grid);
					recover(row, col, n, bombKind, grid);
				}
			}
		}
	}

	public static void bomb(int row, int col, int n, int bombKind, int[][] grid) {
		grid[row][col] = -1;
		int idx = bombKind * 4;

		for (int i = idx; i < idx + 4; i++) {
			int tmpRow = row + y[i];
			int tmpCol = col + x[i];

			if (tmpRow < 0 || tmpRow > n - 1 || tmpCol < 0 || tmpCol > n - 1)
				continue;

			if (grid[tmpRow][tmpCol] <= 0)
				grid[tmpRow][tmpCol]--;
		}
	}

	public static void recover(int row, int col, int n, int bombKind, int[][] grid) {
		grid[row][col] = 1;
		int idx = bombKind * 4;

		for (int i = idx; i < idx + 4; i++) {
			int tmpRow = row + y[i];
			int tmpCol = col + x[i];

			if (tmpRow < 0 || tmpRow > n - 1 || tmpCol < 0 || tmpCol > n - 1)
				continue;

			if (grid[tmpRow][tmpCol] < 0)
				grid[tmpRow][tmpCol]++;
		}
	}
}