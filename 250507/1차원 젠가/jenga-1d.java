import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] blocks = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			blocks[i] = sc.nextInt();
		}
		int s1 = sc.nextInt();
		int e1 = sc.nextInt();
		int s2 = sc.nextInt();
		int e2 = sc.nextInt();

		int[] tmp1 = new int[n];
		int[] tmp2 = new int[n];

		int cnt1 = 0;
		for (int i = 0; i < n; i++) {
			if (i <= n - s1 && i >= n - e1)
				continue;
			tmp1[cnt1++] = blocks[i];
		}

		int cnt2 = 0;
		for (int i = 0; i < cnt1; i++) {
			if (i <= cnt1 - s2 && i >= cnt1 - e2)
				continue;
			tmp2[cnt2++] = tmp1[i];
		}

		System.out.println(cnt2);
		for (int i = cnt2 - 1; i >= 0; i--) {
			System.out.println(tmp2[i]);
		}
	}
}