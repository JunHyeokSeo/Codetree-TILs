import java.util.*;

public class Main {
	static int n;
	static int k;
	static int u;
	static int d;
	static int ans = 0;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static boolean[][] visited;
	static List<Pair> country = new ArrayList<>();
	static List<Pair> selectedCountry = new ArrayList<>();
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
				country.add(new Pair(i, j));
			}
		}

		chooseCountry(0);
		System.out.println(ans);
	}

	public static void init() {
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

	public static void chooseCountry(int index) {
		if (selectedCountry.size() == k) {
			init();
			putStartCountry();
			ans = Math.max(ans, getCountryCnt());
			return;
		}

		if (index == country.size())
			return;

		selectedCountry.add(country.get(index));
		chooseCountry(index + 1);
		selectedCountry.remove(selectedCountry.size() - 1);
		chooseCountry(index + 1);
	}

	public static void putStartCountry() {
		for (Pair pair : selectedCountry) {
			visited[pair.row][pair.col] = true;
			queue.add(pair);
		}
	}

	public static int getCountryCnt() {
		int cnt = queue.size();
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];
				if (canGo(grid[currV.row][currV.col], nextRow, nextCol)) {
					cnt++;
					visited[nextRow][nextCol] = true;
					queue.add(new Pair(nextRow, nextCol));
				}
			}
		}
		return cnt;
	}

	public static boolean canGo(int currHeight, int row, int col) {
		if (!inRange(row, col))
			return false;

		if (visited[row][col])
			return false;

		int diff = Math.abs(currHeight - grid[row][col]);
		return u <= diff && diff <= d;
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	public static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Pair{" +
					       "row=" + row +
					       ", col=" + col +
					       '}';
		}
	}
}