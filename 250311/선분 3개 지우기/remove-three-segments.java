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

					boolean success = true;
					for (int l = 0; l < n - 1; l++) {
						if (l == i || l == j || l == k)
							continue;

						if (b[l] < a[l + 1] || b[l + 1] < a[l]) {
							success = false;
							break;
						}
					}

					if (success)
						cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}