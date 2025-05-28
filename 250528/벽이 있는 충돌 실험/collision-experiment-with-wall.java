import java.util.Scanner;
public class Main {
	static int N;
	static int M;
	static int[][] balls;
	static int[][] dirs;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			balls = new int[N][N];
			dirs = new int[N][N];

			for (int i = 0; i < M; i++) {
				int row = sc.nextInt() - 1;
				int col = sc.nextInt() - 1;
				char d = sc.next().charAt(0);

				balls[row][col] = 1;
				dirs[row][col] = getDir(d);
			}

			for (int i = 0; i < 2 * N; i++) {
				moveBall();
				removeCrushedBalls();
			}

			printBallCnt();
		}
	}

	public static int getDir(char d) {
		if (d == 'U')
			return 0;
		else if (d == 'D')
			return 1;
		else if (d == 'L')
			return 2;
		else
			return 3;
	}

	public static void moveBall() {
		int[][] movedBalls = new int[N][N];
		int[][] changedDirs = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (balls[row][col] != 1)
					continue;

				int nextRow = row + y[dirs[row][col]];
				int nextCol = col + x[dirs[row][col]];

				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					movedBalls[row][col] += balls[row][col];
					changedDirs[row][col] = dirs[row][col] % 2 == 0 ? dirs[row][col] + 1 : dirs[row][col] - 1;
				} else {
					movedBalls[nextRow][nextCol] += balls[row][col];
					changedDirs[nextRow][nextCol] = dirs[row][col];
				}
			}
		}

		balls = movedBalls;
		dirs = changedDirs;
	}

	public static void removeCrushedBalls() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (balls[i][j] <= 1)
					continue;

				balls[i][j] = 0;
				dirs[i][j] = 0;
			}
		}
	}

	public static void printBallCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (balls[i][j] == 1)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}