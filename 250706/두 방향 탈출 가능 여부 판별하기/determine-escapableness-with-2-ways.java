import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static int[][] grid;
	public static int[][] visited;
	public static int[] x = {0, 1};
	public static int[] y = {1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());

		grid = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			tokens = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(visited[n - 1][m - 1]);
	}

	public static void dfs(int row, int col) {
		for (int i = 0; i < 2; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(nextRow, nextCol)) {
				visited[nextRow][nextCol] = 1;
				dfs(nextRow, nextCol);
			}
		}
	}

	public static boolean canGo(int row, int col) {
		return (inRange(row, col) && grid[row][col] == 1 && visited[row][col] == 0);
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > m - 1);
	}
}