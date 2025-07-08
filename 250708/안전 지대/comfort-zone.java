import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int[][] grid;
	static boolean[][] visited;
	static int maxSafeAreaCnt = 0;
	static int maxSafeAreaK = 0;
	static final int MAX_HEIGHT = 100;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		for (int k = 1; k < MAX_HEIGHT; k++) {
			int safeAreaCnt = 0;
			visited = new boolean[n][m];
			
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < m; col++) {
					if (!canGo(k, row, col))
						continue;

					safeAreaCnt++;
					visited[row][col] = true;
					dfs(k, row, col);
				}
			}

			if (safeAreaCnt > maxSafeAreaCnt) {
				maxSafeAreaCnt = safeAreaCnt;
				maxSafeAreaK = k;
			}

			if (safeAreaCnt == 0)
				break;
		}

		System.out.println(maxSafeAreaK + " " + maxSafeAreaCnt);
	}

	public static void dfs(int k, int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(k, nextRow, nextCol)) {
				visited[nextRow][nextCol] = true;
				dfs(k, nextRow, nextCol);
			}
		}
	}

	public static boolean canGo(int k, int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] <= k)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > m - 1);
	}
}