import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int t;
	static int[][] grid;
	static int[][] balls;
	static int ballCnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		balls = new int[n][n];
		for (int i = 0; i < m; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;

			balls[row][col] = 1;
		}

		for (int i = 0; i < t; i++) {
			moveBall();
			removeCrushedBall();
		}

		System.out.println(ballCnt);
	}

	public static void moveBall() {
		//상하좌우
		int[] x = {0, 0, -1, 1};
		int[] y = {-1, 1, 0, 0};
		int[][] newBalls = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (balls[i][j] != 1)
					continue;

				int dir = 0;
				int max = 0;
				for (int k = 0; k < 4; k++) {
					int newRow = i + y[k];
					int newCol = j + x[k];

					if (newRow < 0 || newRow > n - 1 || newCol < 0 || newCol > n - 1)
						continue;

					if (grid[newRow][newCol] > max) {
						max = grid[newRow][newCol];
						dir = k;
					}
				}

				newBalls[i + y[dir]][j + x[dir]] += 1;
			}
		}

		balls = newBalls;
	}

	public static void removeCrushedBall() {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (balls[i][j] > 1)
					balls[i][j] = 0;
				else if (balls[i][j] == 1) {
					cnt++;
				}
			}
		}

		ballCnt = cnt;
	}
}