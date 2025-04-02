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
			int cnt = 0;
			int cntl = 0;

			for (int j = 0; j < n; j++) {
				if (a[j] >= i)
					cnt++;
				if (a[j] + 1 == i) {
					if (cntl < l) {
						cnt++;
						cntl++;
					}
				}
			}

			if (i <= cnt) {
				ans = i;
			}
		}

		System.out.println(ans);
		sc.close();
	}
}