import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static int k;
	public static int n;
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();

		dfs(0);
	}

	public static void dfs(int depth) {
		if (depth == n) {
			for (Integer i : list)
				System.out.print(i + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (list.size() >= 2 && list.get(list.size() - 1) == i && list.get(list.size() - 2) == i)
				continue;

			list.add(i);
			dfs(depth + 1);
			list.remove(list.size() - 1);
		}
	}
}