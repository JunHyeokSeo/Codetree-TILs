import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	static int n;
	static List<Integer> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n + 1];
		f(0);
	}

	public static void f(int curNum) {
		if (curNum == n) {
			print();
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

	public static void print() {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}