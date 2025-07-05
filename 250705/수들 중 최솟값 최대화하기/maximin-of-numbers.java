import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int ans = 0;
	static int[][] grid;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		f(0);
		System.out.println(ans);
	}

	public static void f(int row) {
		if (row == n) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				min = Math.min(min, grid[i][list.get(i)]);
			}
			ans = Math.max(ans, min);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			list.add(i);
			f(row + 1);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}