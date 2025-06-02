import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static float[] x = {0, 0, -0.5F, 0.5F};
	public static float[] y = {0.5F, -0.5F, 0, 0};
	public static int N = 2000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			//공 담는 배열 생성
			List<Ball> balls = new ArrayList<>();

			//공 위치시키기
			int n = sc.nextInt();
			for (int num = 1; num <= n; num++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				int weight = sc.nextInt();
				int dir = getDir(sc.nextLine().trim().charAt(0));

				balls.add(new Ball(num, row, col, dir, weight));
			}

			int lastCrashTime = -1;
			//방향 전환이 없는 평면에서 N만큼 순회하면 충분하다고 판단
			for (int i = 1; i <= N; i++) {
				moveBall(balls);
				int removedBallCnt = removeCrushedBalls(balls);
				if (removedBallCnt != 0)
					lastCrashTime = i;
			}

			System.out.println(lastCrashTime);
		}
	}

	public static int removeCrushedBalls(List<Ball> balls) {
		int removedBallCnt = 0;

		Map<String, List<Ball>> grouped = balls.stream()
				                                  .collect(Collectors.groupingBy(b -> b.getRow() + "_" + b.getCol()));
		List<Ball> toKeep = new ArrayList<>();

		for (Map.Entry<String, List<Ball>> entry : grouped.entrySet()) {
			List<Ball> groupBalls = entry.getValue();
			groupBalls.sort(Comparator.comparingInt(Ball::getWeight).reversed()
					                .thenComparing(Comparator.comparingInt(Ball::getNum).reversed()));
			Ball best = groupBalls.get(0);
			toKeep.add(best);
		}

		removedBallCnt += balls.size() - toKeep.size();
		balls.retainAll(toKeep);

		return removedBallCnt;
	}

	public static void moveBall(List<Ball> balls) {
		for (Ball ball : balls) {
			float nextRow = ball.getNextRow();
			float nextCol = ball.getNextCol();

			ball.setRow(nextRow);
			ball.setCol(nextCol);
		}
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

	public static class Ball{
		private int num;
		private float row;
		private float col;
		private int dir;
		private int weight;

		public Ball(int num, float row, float col, int dir, int weight) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.weight = weight;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public float getRow() {
			return row;
		}

		public void setRow(float row) {
			this.row = row;
		}

		public float getCol() {
			return col;
		}

		public void setCol(float col) {
			this.col = col;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public float getNextRow() {
			return this.row + y[this.dir];
		}

		public float getNextCol() {
			return this.col + x[this.dir];
		}
	}
}