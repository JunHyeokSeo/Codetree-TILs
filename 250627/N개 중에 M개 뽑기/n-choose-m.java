import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		list = new ArrayList<>();

		f(1, 0);
	}

	public static void f(int depth, int cnt) {
		if (depth == m + 1) {
			if (cnt == m)
				print();
			return;
		}

		list.add(depth);
		f(depth + 1, cnt + 1);
		list.remove(list.size() - 1);

		f(depth + 1, cnt);
	}

	public static void print() {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}