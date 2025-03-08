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

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int minX = Math.min(Math.min(x[i], x[j]), x[k]);
					int maxX = Math.max(Math.max(x[i], x[j]), x[k]);
					int minY = Math.min(Math.min(y[i], y[j]), y[k]);
					int maxY = Math.max(Math.max(y[i], y[j]), y[k]);

					if ((x[i] == x[j] || x[j] == x[k] || x[k] == x[i]) && (y[i] == y[j] || y[j] == y[k] || y[k] == y[i]))
						ans = Math.max(ans, Math.abs(maxX - minX) * Math.abs(maxY - minY));
				}
			}
		}

		System.out.println(ans);
	}
}