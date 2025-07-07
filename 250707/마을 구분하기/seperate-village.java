import java.util.*;

public class Main {
	static int n;
	static int villageCnt = 0;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 || visited[i][j])
					continue;

				//사람
				visited[i][j] = true;
				dfs(villageCnt, i, j);
				villageCnt++;
			}
		}

		System.out.println(villageCnt);
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	public static void dfs(int index, int row, int col) {
		if (list.size() > index)
			list.set(index, list.get(index) + 1);
		else
			list.add(1);

		for (int i = 0; i < 4; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(nextRow, nextCol)) {
				visited[nextRow][nextCol] = true;
				dfs(index, nextRow, nextCol);
			}
		}
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (grid[row][col] == 0)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}
}