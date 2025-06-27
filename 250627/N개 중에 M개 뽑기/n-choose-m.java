import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];

		f(0, 0);
	}

	public static void f(int depth, int prevNum) {
		if (depth == m) {
			print();
			return;
		}

		for (int i = prevNum + 1; i <= n; i++) {
			arr[depth] = i;
			f(depth + 1, i);
		}
	}

	public static void print() {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}