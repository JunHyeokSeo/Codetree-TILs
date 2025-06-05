import java.util.*;

public class Main {
	public static final int RANGE = 4000;
	public static final int OFFSET = 2000;
	public static final int BLANC = -1;
	public static int[] x = {0, 0, -1, 1}; // L, R
	public static int[] y = {1, -1, 0, 0}; // U, D
	//인덱스 저장용
	public static int[][] grid = new int[RANGE + 1][RANGE + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			List<Ball> balls = new ArrayList<>();

			//초기화
			for (int i = 0; i <= RANGE; i++) {
				for (int j = 0; j <= RANGE; j++) {
					grid[i][j] = BLANC;
				}
			}

			int n = sc.nextInt();
			for (int num = 1; num <= n; num++) {
				int col = (sc.nextInt() * 2) + OFFSET;
				int row = (sc.nextInt() * 2) + OFFSET;
				int weight = sc.nextInt();
				int dir = getDir(sc.next().charAt(0));

				balls.add(new Ball(num, row, col, dir, weight));
			}

			int lastCrashTime = -1;
			for (int i = 1; i <= RANGE; i++) {
				int crushedBallCnt = moveBalls(balls);
				if (crushedBallCnt != 0)
					lastCrashTime = i;

				for (Ball ball : balls) {
					if (ball.isRemoved)
						continue;

					grid[ball.row][ball.col] = BLANC;
				}
			}

			System.out.println(lastCrashTime);
		}
	}

	public static int moveBalls(List<Ball> balls) {
		int cnt = 0;

		for (Ball ball : balls) {
			if (ball.isRemoved)
				continue;

			int nextRow = ball.row + y[ball.dir];
			int nextCol = ball.col + x[ball.dir];

			if (nextRow < 0 || nextRow > RANGE || nextCol < 0 || nextCol > RANGE) {
				ball.isRemoved = true;
				continue;
			}

			ball.row = nextRow;
			ball.col = nextCol;
			if (grid[nextRow][nextCol] == BLANC) {
				grid[nextRow][nextCol] = balls.indexOf(ball);
			} else {
				Ball origin = balls.get(grid[nextRow][nextCol]);
				//우선순위 탐색
				int cmp = origin.comparePriority(ball);
				if (cmp > 0) {
					ball.isRemoved = true;
					grid[nextRow][nextCol] = balls.indexOf(origin);
				} else {
					origin.isRemoved = true;
					grid[nextRow][nextCol] = balls.indexOf(ball);
				}
				cnt++;
			}
		}

		return cnt;
	}

	public static int getDir(char d) {
		switch (d) {
			case 'U': return 0;
			case 'D': return 1;
			case 'L': return 2;
			case 'R': return 3;
			default: throw new IllegalArgumentException("Invalid direction: " + d);
		}
	}

	public static class Ball {
		public int num;
		public int row;
		public int col;
		public int dir;
		public int weight;
		public boolean isRemoved;

		public Ball(int num, int row, int col, int dir, int weight) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.weight = weight;
			this.isRemoved = false;
		}

		public int comparePriority(Ball other) {
			if (this.weight != other.weight) {
				return Integer.compare(this.weight, other.weight);
			}
			return Integer.compare(this.num, other.num);
		}
	}
}
