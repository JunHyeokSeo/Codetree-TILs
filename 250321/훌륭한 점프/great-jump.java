import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = 101;
		for (int i = 100; i >= 1; i--) {
			int cnt = 0;
			int[] tmp = new int[n];
			for (int j = 0; j < n; j++) {
				if (arr[j] > i)
					continue;
				tmp[cnt++] = j;
			}

			boolean success = tmp[0] == 0;

			for (int j = 1; j < cnt; j++) {
				int diff = Math.abs(tmp[j] - tmp[j - 1]);
				if (diff > k) {
					success = false;
					break;
				}
			}

			if (!success)
				break;

			ans = Math.min(ans, i);
		}

		System.out.println(ans);
	}
}