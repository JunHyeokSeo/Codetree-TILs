import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= 10000; i++) {
			boolean success = true;
			for (int j = 1; j <= n; j++) {
				int v = (int) (i * Math.pow(2, j));

				if (a[j - 1] > v || b[j - 1] < v) {
					success = false;
					break;
				}
			}

			if (success)
				ans = Math.min(ans, i);
		}

		System.out.println(ans);
	}
}