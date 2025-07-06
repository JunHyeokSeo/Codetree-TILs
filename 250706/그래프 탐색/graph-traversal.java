import java.util.Scanner;
public class Main {
	public static int n;
	public static int m;
	public static int cnt = 0;
	public static int[][] grid;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt() - 1;
			int v2 = sc.nextInt() - 1;

			grid[v1][v2] = 1;
			grid[v2][v1] = 1;
		}

		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int vertex) {
		for (int i = 1; i < n; i++) {
			if (grid[vertex][i] != 1 || visited[i])
				continue;

			visited[i] = true;
			cnt++;
			dfs(i);
		}
	}
}