import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
public class Main {
	static int n;
	static int t;
	static int[] top = new int[n];
	static int[] bottom = new int[n];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		top = new int[n];
		bottom = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = sc.nextInt();
		}
		for (int i = n - 1; i >= 0; i--) {
			bottom[i] = sc.nextInt();
		}

		for (int i = 0; i < t; i++) {
			swap();
		}

		for (int i = 0; i < n; i++) {
			System.out.print(top[i] + " ");
		}
		System.out.println();
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(bottom[i] + " ");
		}
	}

	public static void swap() {
		int tmpTop = top[n - 1];
		int tmpBottom = bottom[0];

		for (int i = n - 1; i >= 1; i--) {
			top[i] = top[i - 1];
		}
		top[0] = tmpBottom;

		for (int i = 0; i < n - 1; i++) {
			bottom[i] = bottom[i + 1];
		}
		bottom[n - 1] = tmpTop;
	}
}