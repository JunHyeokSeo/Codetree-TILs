import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
			c[i] = sc.nextInt() - 1;
		}

		int maxCnt = 0;
		for (int i = 0; i < 3; i++) {
			int[] arr = new int[3];
			arr[i] = 1;

			int cnt = 0;
			for (int j = 0; j < n; j++) {
				int tmp = arr[b[j]];
				arr[b[j]] = arr[a[j]];
				arr[a[j]] = tmp;

				if (arr[c[j]] == 1)
					cnt++;
			}

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}