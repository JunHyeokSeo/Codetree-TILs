import java.util.*;

public class Main {
	static int n;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] grid;
	static boolean[][] visited;
	static int peopleNum;
	static List<Integer> peopleNums = new ArrayList<>();

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
				if (!canGo(i, j))
					continue;
				peopleNum = 1;
				visited[i][j] = true;
				dfs(i, j);
				peopleNums.add(peopleNum);
			}
		}

		System.out.println(peopleNums.size());
		Collections.sort(peopleNums);
		for (Integer integer : peopleNums) {
			System.out.println(integer);
		}
	}

	public static void dfs(int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nextRow = row + y[i];
			int nextCol = col + x[i];

			if (canGo(nextRow, nextCol)) {
				visited[nextRow][nextCol] = true;
				peopleNum++;
				dfs(nextRow, nextCol);
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