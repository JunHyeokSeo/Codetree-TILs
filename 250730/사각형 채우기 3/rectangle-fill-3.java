import java.util.Scanner;
public class Main {
	static long[] dp;
	static final long MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];

		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= n; i++) {
			dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2]) % MOD;
			for (int j = 3; j <= i; j++) {
				dp[i] = (dp[i] + (2 * dp[i - j])) % MOD;
			}
		}

		System.out.println(dp[n]);
	}
}