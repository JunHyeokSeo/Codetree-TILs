import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	static int n;
	static final int MAX_N = 8;
	static List<Integer> list = new ArrayList<>();
	static boolean[] visited = new boolean[MAX_N + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		f(0);
	}

	public static void f(int curNum) {
		if (curNum == n) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			list.add(i);
			f(curNum + 1);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}