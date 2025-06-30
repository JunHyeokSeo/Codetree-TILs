import java.util.Scanner;
public class Main {
	public static int tot = 0;
	public static int n;
	public static int minDiff = Integer.MAX_VALUE;
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			int in = sc.nextInt();
			arr[i] = in;
			tot += in;
		}

		f(0, 0, 0);
		System.out.println(minDiff);
	}

	public static void f(int index, int cnt, int sum) {
		if (cnt == n) {
			minDiff = Math.min(minDiff, Math.abs((tot - sum) - sum));
			return;
		}

		if (index == 2 * n)
			return;

		f(index + 1, cnt + 1, sum + arr[index]);
		f(index + 1, cnt, sum);
	}
}