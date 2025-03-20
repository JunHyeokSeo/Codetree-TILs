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

		for (int i = 0; i <= 21; i++) {
			for (int j = 0; j <= 21; j++) {
				for (int k = 0; k <= 21; k++) {
					int[] arr = new int[n];

					for (int l = 0; l < n; l++) {
						if (i < 11 && y[l] == i)
							arr[l] = 1;
						if (i >= 11 && x[l] == (i - 11))
							arr[l] = 1;
						if (j < 11 && y[l] == j)
							arr[l] = 1;
						if (j >= 11 && x[l] == (j - 11))
							arr[l] = 1;
						if (k < 11 && y[l] == k)
							arr[l] = 1;
						if (k >= 11 && x[l] == (k - 11))
							arr[l] = 1;
					}

					int sum = 0;
					for (int l = 0; l < n; l++) {
						sum += arr[l];
					}
					if (sum == n) {
						System.out.println(1);
						return;
					}
				}
			}
		}

		System.out.println(0);
	}
}