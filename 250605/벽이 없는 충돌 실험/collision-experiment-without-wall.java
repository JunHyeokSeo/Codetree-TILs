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
			//공 담는 Map 생성
			Map<String, Ball> balls = new HashMap<>();

			//공 위치시키기
			int n = sc.nextInt();
			for (int num = 1; num <= n; num++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				int weight = sc.nextInt();
				int dir = getDir(sc.nextLine().trim().charAt(0));

				Ball ball = new Ball(num, row, col, dir, weight);
				balls.put(ball.getRowCol(), ball);
			}

			int lastCrashTime = -1;
			//방향 전환이 없는 평면에서 N * 2만큼 순회하면 충분하다고 판단
			for (int i = 1; i <= N * 2; i++) {
				if (moveBall(balls) != 0)
					lastCrashTime = i;

				if (balls.isEmpty())
					break;
			}

			System.out.println(lastCrashTime);
		}
	}

	public static int moveBall(Map<String, Ball> balls) {
		int diff;

		Map<String, Ball> tmpMap = new HashMap<>();

		for (Ball ball : balls.values()) {
			ball.setRow(ball.getNextRow());
			ball.setCol(ball.getNextCol());

			String newKey = ball.getRowCol();
			Ball existing = tmpMap.get(newKey);

			if (existing == null) {
				tmpMap.put(newKey, ball);
			} else {
				tmpMap.put(newKey, moreImportant(existing, ball));
			}
		}

		diff = balls.size() - tmpMap.size();
		balls.clear();
		balls.putAll(tmpMap);

		return diff;
	}

	private static Ball moreImportant(Ball a, Ball b) {
		if (a.getWeight() != b.getWeight()) {
			return a.getWeight() > b.getWeight() ? a : b;
		}
		return a.getNum() > b.getNum() ? a : b;
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

		public String getRowCol() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.row).append("_").append(this.col);
			return sb.toString();
		}
	}
}