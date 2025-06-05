import java.util.*;

public class Main {
	public static float[] x = {0f, 0f, -0.5f, 0.5f}; // L, R
	public static float[] y = {0.5f, -0.5f, 0f, 0f}; // U, D

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			PriorityQueue<Event> pq = new PriorityQueue<>();
			List<Ball> balls = new ArrayList<>();

			int n = sc.nextInt();
			for (int num = 1; num <= n; num++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				int weight = sc.nextInt();
				int dir = getDir(sc.next().charAt(0));
				balls.add(new Ball(num, row, col, dir, weight)); // 좌표 float 그대로 저장
			}

			// 충돌 이벤트 탐색
			for (int i = 0; i < balls.size(); i++) {
				for (int j = i + 1; j < balls.size(); j++) {
					Ball a = balls.get(i);
					Ball b = balls.get(j);

					Integer time = getCollisionTime(a, b);
					if (time != null) {
						pq.add(new Event(time, a, b));
					}
				}
			}

			int lastCrashTime = -1;
			while (!pq.isEmpty()) {
				Event event = pq.poll();
				Ball a = event.a;
				Ball b = event.b;

				if (a.removed || b.removed) continue;

				lastCrashTime = event.t;
				int cmp = a.comparePriority(b);
				if (cmp > 0) {
					b.setRemoved(true);
				} else {
					a.setRemoved(true);
				}
			}

			System.out.println(lastCrashTime == -1 ? lastCrashTime : lastCrashTime / 2);
		}
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

	// 충돌 시간 계산
	public static Integer getCollisionTime(Ball a, Ball b) {
		float rowA = a.getRow();
		float colA = a.getCol();
		float dirRowA = y[a.getDir()];
		float dirColA = x[a.getDir()];

		float rowB = b.getRow();
		float colB = b.getCol();
		float dirRowB = y[b.getDir()];
		float dirColB = x[b.getDir()];

		float deltaRow = rowB - rowA;
		float deltaCol = colB - colA;

		float deltaDirRow = dirRowA - dirRowB;
		float deltaDirCol = dirColA - dirColB;

		if (deltaDirRow == 0 && deltaDirCol == 0) {
			return null; // 같은 방향
		}

		Float tRow = null, tCol = null;

		if (Math.abs(deltaDirRow) > 1e-8) {
			tRow = deltaRow / deltaDirRow;
		}
		if (Math.abs(deltaDirCol) > 1e-8) {
			tCol = deltaCol / deltaDirCol;
		}

		if (tRow != null && tCol != null) {
			if (Math.abs(tRow - tCol) > 1e-8) return null; // 같은 시간에 도착해야
			if (tRow <= 0) return null;
			if (Math.abs(tRow * 2 - Math.round(tRow * 2)) > 1e-8) return null; // 0.5초 배수인지
			return Math.round(tRow * 2); // 0.5초 단위로 출력
		} else if (tRow != null) {
			if (Math.abs(deltaCol) > 1e-8) return null; // col 차이가 0이어야
			if (tRow <= 0) return null;
			if (Math.abs(tRow * 2 - Math.round(tRow * 2)) > 1e-8) return null;
			return Math.round(tRow * 2);
		} else if (tCol != null) {
			if (Math.abs(deltaRow) > 1e-8) return null; // row 차이가 0이어야
			if (tCol <= 0) return null;
			if (Math.abs(tCol * 2 - Math.round(tCol * 2)) > 1e-8) return null;
			return Math.round(tCol * 2);
		}

		return null;
	}

	public static class Ball {
		private int num;
		private float row;
		private float col;
		private int dir;
		private int weight;
		private boolean removed;

		public Ball(int num, float row, float col, int dir, int weight) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.weight = weight;
			this.removed = false;
		}

		public int getNum() { return num; }
		public float getRow() { return row; }
		public float getCol() { return col; }
		public int getDir() { return dir; }
		public int getWeight() { return weight; }
		public boolean isRemoved() { return removed; }
		public void setRemoved(boolean removed) { this.removed = removed; }

		public int comparePriority(Ball other) {
			if (this.weight != other.weight) {
				return Integer.compare(this.weight, other.weight);
			}
			return Integer.compare(this.num, other.num);
		}
	}

	public static class Event implements Comparable<Event> {
		int t; // 0.5초 단위 시간 (1 = 0.5초, 2 = 1초, 3 = 1.5초, ...)
		Ball a, b;

		public Event(int t, Ball a, Ball b) {
			this.t = t;
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Event other) {
			return Integer.compare(this.t, other.t); // 시간 오름차순
		}
	}
}
