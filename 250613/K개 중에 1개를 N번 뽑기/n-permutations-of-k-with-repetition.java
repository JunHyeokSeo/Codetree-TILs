import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		choose(0, n, k);
	}

	public static void print() {
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	public static void choose(int depth, int n, int k) {
		if (depth == n) {
			print();
			return;
		}

		for (int i = 1; i <= k; i++) {
			list.add(i);
			choose(depth + 1, n, k);
			list.remove(list.size() - 1);
		}
	}
}