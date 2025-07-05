import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int ans = Integer.MAX_VALUE;
	public static int[][] cost;
	public static boolean[] visited;
	public static List<Integer> per = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cost = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		per.add(0);
		f(1, 0, 0);
		System.out.println(ans);
	}

	public static void f(int index, int costSum, int prevIdx) {
		if (index == n) {
			if (cost[prevIdx][0] != 0)
				ans = Math.min(ans, costSum + cost[prevIdx][0]);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (visited[i] || cost[prevIdx][i] == 0)
				continue;

			visited[i] = true;
			per.add(i);
			f(index + 1, costSum + cost[prevIdx][i], i);
			per.remove(per.size() - 1);
			visited[i] = false;
		}
	}
}