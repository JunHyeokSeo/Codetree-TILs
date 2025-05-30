import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int m; //구슬 개수
	public static int t; //시간
	public static int k; //최대 구슬 수
	public static List<Ball>[][] grid;
	public static int[] x = {0, 0, -1, 1};
	public static int[] y = {-1, 1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt(); //구슬 개수
		t = sc.nextInt(); //시간
		k = sc.nextInt(); //최대 구슬 수

		grid = getGrid();

		//세팅
		for (int num = 1; num <= m; num++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			int dir = getDir(sc.next().charAt(0)); //dir
			int speed = sc.nextInt(); //속도

			Ball ball = new Ball(dir, num, speed);
			grid[row][col].add(ball);
		}

		//초에 따라 구슬 이동
		for (int time = 0; time < t; time++) {
			moveBall();
			removeCrashedBalls();
		}

		System.out.println(getBallCnt());
	}

	public static List<Ball>[][] getGrid() {
		@SuppressWarnings("unchecked")
		List<Ball>[][] tempGrid = (ArrayList<Ball>[][]) new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tempGrid[i][j] = new ArrayList<>();
			}
		}

		return tempGrid;
	}

	public static void moveBall() {
		List<Ball>[][] tmpGrid = getGrid();

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				List<Ball> balls = grid[row][col];
				if (balls.isEmpty())
					continue;

				for (Ball ball : balls) {
					int nextRow = getNextPosition(ball, row, y);
					int nextCol = getNextPosition(ball, col, x);

					//결정된 포인트에 구슬 이동
					tmpGrid[nextRow][nextCol].add(ball);
				}
			}
		}

		grid = tmpGrid;
	}

	public static int getNextPosition(Ball ball, int curPos, int[] dyx) {
		int nextPos = curPos;
		int speed = ball.speed;
		int dir = ball.dir;

		while (speed > 0) {
			//새로운 이동 포인트 탐색
			int tmpPos = nextPos + (dyx[dir] * speed);

			if (nextPos - tmpPos == 0)
				break;

			//범위 초과
			if (tmpPos < 0) {
				speed -= nextPos;
				nextPos = 0;
				dir++;
			} else if (tmpPos > n - 1) {
				speed -= (n - 1) - nextPos;
				nextPos = n - 1;
				dir--;
			} else {
				//속도 저하
				speed -= Math.abs(nextPos - tmpPos);

				//위치이동
				nextPos = tmpPos;
			}
		}

		return nextPos;
	}

	public static void removeCrashedBalls() {
		for (List<Ball>[] row : grid) {
			for (List<Ball> balls : row) {
				if (balls.size() <= k)
					continue;

				//우선순위에 따라 정렬
				balls.sort((b1, b2) -> {
					if (b1.getSpeed() != b2.getSpeed()) {
						return Integer.compare(b2.getSpeed(), b1.getSpeed()); // speed 내림차순
					} else {
						return Integer.compare(b2.getNum(), b1.getNum()); // num 내림차순
					}
				});

				//볼 갯수에 맞도록 삭제
				balls.subList(k, balls.size()).clear();
			}
		}
	}

	public static int getBallCnt() {
		int cnt = 0;
		for (List<Ball>[] lists : grid) {
			for (List<Ball> balls : lists) {
				if (balls.isEmpty())
					continue;

				cnt += balls.size();
			}
		}

		return cnt;
	}

	public static int getDir(char d) {
		switch (d) {
			case 'U':
				return 0;
			case 'D':
				return 1;
			case 'L':
				return 2;
			default:
				return 3;
		}
	}

	public static class Ball {
		private int dir;
		private int num;
		private int speed;

		public Ball(int dir, int num, int speed) {
			this.dir = dir;
			this.num = num;
			this.speed = speed;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		@Override
		public String toString() {
			return "Ball{" +
					       "dir=" + dir +
					       ", num=" + num +
					       ", speed=" + speed +
					       '}';
		}
	}
}