import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int minMax = Integer.MAX_VALUE;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (i % 2 == 1 || j % 2 == 1)
					continue;

				int cnt1 = 0;
				int cnt2 = 0;
				int cnt3 = 0;
				int cnt4 = 0;
				for (int k = 0; k < n; k++) {
					if (x[k] > i && y[k] > j)
						cnt1++;
				}

				for (int k = 0; k < n; k++) {
					if (x[k] < i && y[k] > j)
						cnt2++;
				}

				for (int k = 0; k < n; k++) {
					if (x[k] < i && y[k] < j)
						cnt3++;
				}

				for (int k = 0; k < n; k++) {
					if (x[k] > i && y[k] < j)
						cnt4++;
				}

				minMax = Math.min(minMax, Math.max(Math.max(Math.max(cnt1, cnt2), cnt3), cnt4));
			}
		}

		System.out.println(minMax);
	}
}