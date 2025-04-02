import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		int ans = 0;
		for (int i = 1; i <= 100; i++) {
			int[] tmp = Arrays.copyOf(a, a.length);
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (i - a[j] == 1 && cnt <= l) {
					cnt++;
					tmp[j] = i;
				}
			}

			// H 탐색
			for (int j = 0; j < n; j++) {
				int hCnt = 0;
				for (int k = 0; k < n; k++) {
					if (tmp[j] <= tmp[k])
						hCnt++;
				}
				if (tmp[j] <= hCnt)
					ans = Math.max(ans, tmp[j]);
			}
		}

		System.out.println(ans);
		sc.close();
	}
}