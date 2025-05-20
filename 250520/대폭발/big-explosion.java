import java.util.Scanner;

public class Main {
	static int[] x = {1, -1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		grid = new int[n][n];
		grid[r][c] = 1;

		for (int i = 1; i <= m; i++) {
			int[][] tmp = new int[n][n];

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (grid[row][col] == 0)
						continue;

					tmp[row][col] = 1;
					int dist = (int) Math.pow(2, (i - 1));

					for (int j = 0; j < 4; j++) {
						int tmpR = row + (y[j] * dist);
						int tmpC = col + (x[j] * dist);

						if (tmpR < 0 || tmpR > n - 1 || tmpC < 0 || tmpC > n - 1)
							continue;

						tmp[tmpR][tmpC] = 1;
					}
				}
			}

			grid = tmp;
		}

		int cnt = 0;
		for (int[] ints : grid) {
			for (int anInt : ints) {
				cnt += anInt;
			}
		}

		System.out.println(cnt);
	}
}