import java.util.Scanner;
public class Main {
	static int n;
	static int ans = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		f(0, 0);
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static void f(int hopCnt, int index) {
		if (index >= n - 1) {
			ans = Math.min(ans, hopCnt);
			return;
		}

		for (int i = 1; i <= arr[index]; i++)
			f(hopCnt + 1, index + i);
	}
}