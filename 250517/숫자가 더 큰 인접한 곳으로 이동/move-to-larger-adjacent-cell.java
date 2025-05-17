import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[] x = {1, -1, 0, 0};
		int[] y = {0, 0, 1, -1};
		int[][] grid = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		while (true) {
			System.out.print(grid[r][c] + " ");

			int tmpX = c;
			int tmpY = r;
			for (int i = 0; i < 4; i++) {
				int nextX = c + x[i];
				int nextY = r + y[i];

				if (nextX <= 0 || nextX > n || nextY <= 0 || nextY > n)
					continue;

				if (grid[nextY][nextX] > grid[r][c]) {
					tmpX = nextX;
					tmpY = nextY;
				}
			}

			if (c == tmpX && r == tmpY)
				break;

			c = tmpX;
			r = tmpY;
		}
	}

}