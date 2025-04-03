import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x1 = new int[n];
		int[] x2 = new int[n];
		for (int i = 0; i < n; i++) {
			x1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			boolean allOver = true;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i == j || i == k || j == k)
						continue;

					if (x2[j] < x1[k] || x1[j] > x2[k]) {
						allOver = false;
						break;
					}
				}
			}

			if (allOver) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}
}