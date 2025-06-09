import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int t;
	static int[][] idx;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};

	public static class Ball {
		int row, col, dir, num, weight;

		public Ball(int row, int col, int dir, int num, int weight) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.num = num;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}
	}

	public static int getDir(char dir) {
		switch (dir) {
			case 'U': return 0;
			case 'D': return 1;
			case 'L': return 2;
			case 'R': return 3;
			default: throw new IllegalArgumentException("Invalid direction: " + dir);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Ball> balls = new ArrayList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		idx = getIdxs();

		for (int i = 0; i < m; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			char d = sc.next().charAt(0);
			int w = sc.nextInt();

			balls.add(new Ball(r, c, getDir(d), i, w));
			idx[r][c] = balls.size() - 1;
		}

		for (int i = 0; i < t; i++) {
			//이동
			balls = moveBall(balls);
		}

		//결과
		int ballCnt = balls.size();
		int heavyWeight = balls.stream()
				                  .mapToInt(Ball::getWeight)
				                  .max()
				                  .orElse(0);

		System.out.println(ballCnt + " " + heavyWeight);
	}

	public static int[][] getIdxs() {
		int[][] idxs = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				idxs[i][j] = -1;
			}
		}

		return idxs;
	}

	public static List<Ball> moveBall(List<Ball> balls) {
		int[][] movedIdxs = getIdxs();
		List<Ball> movedBalls = new ArrayList<>();

		for (Ball ball : balls) {
			int nextRow = ball.row + y[ball.dir];
			int nextCol = ball.col + x[ball.dir];

			//방향 전환
			if (nextCol < 0 || nextCol >= n || nextRow < 0 || nextRow >= n) {
				ball.dir = ball.dir % 2 == 0 ? ball.dir + 1 : ball.dir - 1;
			} else {
				ball.row = nextRow;
				ball.col = nextCol;
			}

			//업데이트
			int movedIdx = movedIdxs[ball.row][ball.col];
			if (movedIdx == -1) {
				movedBalls.add(ball);
				movedIdxs[ball.row][ball.col] = movedBalls.size() - 1;
			} else {
				Ball origin = movedBalls.get(movedIdx);
				Ball mergeBall = getMergeBall(ball, origin);
				movedBalls.set(movedIdx, mergeBall);
			}
		}

		idx = movedIdxs;
		return movedBalls;
	}

	public static Ball getMergeBall(Ball a, Ball b) {
		Ball biggerBall = a.num > b.num ? a : b;

		int row = a.row;
		int col = a.col;
		int weight = a.weight + b.weight;
		int num = biggerBall.num;
		int dir = biggerBall.dir;

		return new Ball(row, col, dir, num, weight);
	}
}