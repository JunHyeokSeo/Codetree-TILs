import java.util.*;

public class Main {
	static int n, k, r1, c1, r2, c2, ans = Integer.MAX_VALUE;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid, step;
	static List<Pair> walls = new ArrayList<>();
	static List<Pair> removedWalls = new ArrayList<>();
	static Queue<Pair> queue = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
				if (grid[i][j] == 1)
					walls.add(new Pair(i, j));
			}
		}
		r1 = sc.nextInt() - 1;
		c1 = sc.nextInt() - 1;
		r2 = sc.nextInt() - 1;
		c2 = sc.nextInt() - 1;

		findMinimumTime(0);
		System.out.println(ans == Integer.MAX_VALUE ? - 1 : ans);
	}

	static void init() {
		step = new int[n][n];
		visited = new boolean[n][n];
		push(r1, c1, 0);
	}

	static void push(int row, int col, int stepNum) {
		step[row][col] = stepNum;
		visited[row][col] = true;
		queue.add(new Pair(row, col));
	}

	static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (!removedWalls.contains(new Pair(row, col)) && grid[row][col] == 1)
			return false;
		return !visited[row][col];
	}

	static void findMinimumTime(int index) {
		if (removedWalls.size() == k) {
			init();
			bfs();
			return;
		}

		if (index == walls.size())
			return;

		removedWalls.add(walls.get(index));
		findMinimumTime(index + 1);
		removedWalls.remove(removedWalls.size() - 1);
		findMinimumTime(index + 1);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();

			//도착 보장
			if (currV.row == r2 && currV.col == c2) {
				queue.clear();
				ans = Math.min(ans, step[currV.row][currV.col]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];
				if (canGo(nextRow, nextCol)) {
					push(nextRow, nextCol, step[currV.row][currV.col] + 1);
				}
			}
		}
	}

	static class Pair {
		int row, col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Pair)) return false;
			Pair other = (Pair) obj;
			return row == other.row && col == other.col;
		}
	}
}