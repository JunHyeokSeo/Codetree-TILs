import java.util.Scanner;
public class Main {
	static int n;
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if (n <= 2) {
			System.out.println(1);
			return;
		}

		memo = new int[n + 1];
		memo[1] = 1;
		memo[2] = 1;
		dp();
		System.out.println(memo[n]);
	}

	public static void dp() {
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
	}
}