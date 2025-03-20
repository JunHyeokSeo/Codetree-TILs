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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 1 || j % 2 == 1)
					continue;

				int max = 0;
				int cnt = 0;
				for (int k = 0; k < n; k++) {
					if (x[k] > i && y[k] > j)
						cnt++;
				}
				max = Math.max(max, cnt);

				cnt = 0;
				for (int k = 0; k < n; k++) {
					if (x[k] < i && y[k] > j)
						cnt++;
				}
				max = Math.max(max, cnt);

				cnt = 0;
				for (int k = 0; k < n; k++) {
					if (x[k] < i && y[k] < j)
						cnt++;
				}
				max = Math.max(max, cnt);

				cnt = 0;
				for (int k = 0; k < n; k++) {
					if (x[k] > i && y[k] < j)
						cnt++;
				}
				max = Math.max(max, cnt);

				minMax = Math.min(minMax, max);
			}
		}

		System.out.println(minMax);
	}
}