import java.util.Scanner;
public class Main {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];

		if (n == 1) {
			System.out.println(1);
			return;
		}

		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] * 2 + 1;
		}

		System.out.println(dp[n]);
	}
}