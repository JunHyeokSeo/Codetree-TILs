import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int[][] grid;
	static int[] x = {1, 0, -1, 0};
	static int[] y = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int bombCols = sc.nextInt() - 1;
			bomb(bombCols);
			gravity();
		}

		for (int[] ints : grid) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	public static void gravity() {
		int[][] tmp = new int[n][n];
		for (int col = 0; col < n; col++) {
			int tmpIdx = n - 1;
			for (int row = n - 1; row >= 0; row--) {
				if (grid[row][col] == 0)
					continue;

				tmp[tmpIdx--][col] = grid[row][col];
			}
		}

		grid = tmp;
	}

	public static void bomb(int bombCols) {
		int topItemIdx = getTopItemIdx(bombCols);
		if (topItemIdx == -1)
			return;

		//폭발
		int size = grid[topItemIdx][bombCols];
		grid[topItemIdx][bombCols] = 0;

		if (size == 1)
			return;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < size; j++) {
				int row = topItemIdx + (y[i] * j);
				int col = bombCols + (x[i] * j);

				if (row < 0 || row > n - 1 || col < 0 || col > n - 1)
					continue;

				grid[row][col] = 0;
			}
		}
	}

	public static int getTopItemIdx(int bombCols) {
		for (int i = 0; i < n; i++) {
			if (grid[i][bombCols] != 0)
				return i;
		}

		return -1;
	}
}