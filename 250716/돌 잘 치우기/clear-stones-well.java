import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int n;
	static int k;
	static int m;
	static int ans = 0;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static int[][] startPoints;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		startPoints = new int[k][2];
		for (int i = 0; i < k; i++) {
			startPoints[i][0] = sc.nextInt() - 1;
			startPoints[i][1] = sc.nextInt() - 1;
		}

		eraseStone(0, 0, 0);
		System.out.println(ans);
	}

	public static void eraseStone(int cnt, int row, int col) {
		if (cnt == m) {
			ans = Math.max(ans, getBlockCnt());
			return;
		}

		if (!inRange(row, col))
			return;

		int nextRow = row;
		int nextCol = col + 1;
		if (nextCol > n - 1) {
			nextRow++;
			nextCol = 0;
		}

		if (grid[row][col] == 1) {
			grid[row][col] = 0;
			eraseStone(cnt + 1, nextRow, nextCol);
			grid[row][col] = 1;
		}
		eraseStone(cnt, nextRow,  nextCol);
	}

	public static int getBlockCnt() {
		initializing();
		for (int i = 0; i < k; i++) {
			int strRow = startPoints[i][0];
			int strCol = startPoints[i][1];
			push(strRow, strCol);
		}
		
		return bfs();
	}


	public static int bfs () {
		int cnt = 1;
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];
				if (canGo(nextRow, nextCol)) {
					push(nextRow, nextCol);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] == 1)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	public static void push(int row, int col) {
		visited[row][col] = true;
		queue.add(new Pair(row, col));
	}

	public static void initializing() {
		if (visited == null) {
			visited = new boolean[n][n];
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static class Pair {
		public int row;
		public int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}