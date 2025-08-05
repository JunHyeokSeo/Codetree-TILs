import java.util.Scanner;
public class Main {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];

		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] * 3 - 1;
		}

		System.out.println(dp[n]);
	}
}