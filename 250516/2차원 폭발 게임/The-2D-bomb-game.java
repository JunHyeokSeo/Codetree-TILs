import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int i = 0; i < k; i++) {
			bomb();
			gravity();
			turn();
			gravity();
		}

		print();
	}

	public static void bomb() {
		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {
				if (grid[row][col] == 0)
					continue;

				int serialItemCnt = getSerialItemCnt(row, col, grid[row][col]);
				if (serialItemCnt < m)
					continue;

				for (int i = 0; i < serialItemCnt; i++)
					grid[row + i][col] = 0;
			}
		}
	}

	public static int getSerialItemCnt(int row, int col, int num) {
		int cnt = 1;
		for (int idx = row + 1; idx < n; idx++) {
			if (num != grid[idx][col])
				break;

			cnt++;
		}

		return cnt;
	}

	public static void gravity() {
		int[][] tmp = new int[n][n];

		for (int col = 0; col < n; col++) {
			int idx = n - 1;
			for (int row = n - 1; row >= 0; row--) {
				if (grid[row][col] == 0)
					continue;

				tmp[idx--][col] = grid[row][col];
			}
		}

		grid = tmp;
	}

	public static void turn() {
		int[][] tmp = new int[n][n];

		for (int col = 0; col < n; col++) {
			for (int row = n - 1; row >= 0; row--) {
				tmp[col][(n - 1) - row] = grid[row][col];
			}
		}

		grid = tmp;
	}

	public static void print() {
		int cnt = 0;
		for (int[] ints : grid) {
			for (int anInt : ints) {
				if (anInt != 0)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}