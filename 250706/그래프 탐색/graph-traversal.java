import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static int n;
	public static int m;
	public static int cnt = 0;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt() - 1;
			int v2 = sc.nextInt() - 1;

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		visited[0] = true;
		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int vertex) {
		for (Integer node : graph[vertex]) {
			if (visited[node])
				continue;

			visited[node] = true;
			cnt++;
			dfs(node);
		}
	}
}