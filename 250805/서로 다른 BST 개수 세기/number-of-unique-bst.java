import java.util.Scanner;
public class Main {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int node = 2; node <= n; node++) {
			for (int root = 1; root <= node; root++) {
				dp[node] += dp[root - 1] * dp[node - root];
			}
		}

		System.out.println(dp[n]);
	}
}