import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 복사
				int[][] tmp = new int[n][n];
				for (int l = 0; l < n; l++) {
					System.arraycopy(grid[l], 0, tmp[l], 0, n);
				}

				//폭발 및 중력
				bomb(tmp, i, j);
				tmp = gravity(tmp);
				maxCnt = Math.max(maxCnt, getCombCnt(tmp));
			}
		}

		System.out.println(maxCnt);
	}

	public static void bomb(int[][] tmp, int row, int col) {
		int width = tmp[row][col];
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};
		tmp[row][col] = 0;

		if (width == 1)
			return;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < width; j++) {
				int tmpY = row + (y[i] * j);
				int tmpX = col + (x[i] * j);
				if (tmpY < 0 || tmpY > n - 1 || tmpX < 0 || tmpX > n - 1)
					break;

				tmp[tmpY][tmpX] = 0;
			}
		}
	}

	public static int[][] gravity(int[][] grid) {
		int[][] tmp = new int[n][n];

		for (int col = 0; col < n; col++) {
			int idx = n - 1;
			for (int row = n - 1; row >= 0; row--) {
				if (grid[row][col] == 0)
					continue;

				tmp[idx--][col] = grid[row][col];
			}
		}

		return tmp;
	}

	public static int getCombCnt(int[][] tmp) {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmp[i][j] == 0)
					continue;

				int tmpX = j + 1;
				int tmpY = i + 1;

				if (tmpX < n && tmp[i][j] == tmp[i][tmpX])
					cnt++;

				if (tmpY < n && tmp[i][j] == tmp[tmpY][j])
					cnt++;
			}
		}

		return cnt;
	}

}