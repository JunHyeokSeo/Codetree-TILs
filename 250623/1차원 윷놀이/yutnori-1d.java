import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int k;
	static int ans = 0;
	static int[] nums;
	static int[] movePlayer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		nums = new int[n];
		movePlayer = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		f(0);
		System.out.println(ans);
	}

	public static void f(int idx) {
		if (idx == n) {
			ans = Math.max(ans, simulation());
			return;
		}

		for (int i = 0; i < k; i++) {
			movePlayer[idx] = i;
			f(idx + 1);
		}
	}

	public static int simulation() {
		int[] score = new int[k];
		for (int i = 0; i < n; i++) {
			score[movePlayer[i]] += nums[i];
		}

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (score[i] >= m - 1)
				cnt++;
		}

		return cnt;
	}
}