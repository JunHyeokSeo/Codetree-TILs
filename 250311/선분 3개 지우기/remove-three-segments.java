import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] r;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (i == j || j == k || k == i)
						continue;

					r = new int[101];
					for (int l = 0; l < n; l++) {
						if (l == i || l == j || l == k)
							continue;

						for (int m = a[l]; m <= b[l]; m++) {
							r[m] += 1;
						}
					}

					int max = 0;
					for (int m = 0; m < 101; m++) {
						max = Math.max(max, r[m]);
					}

					if (max == 1) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}