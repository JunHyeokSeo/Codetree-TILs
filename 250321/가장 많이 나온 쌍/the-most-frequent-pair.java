import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M];
		int[] b = new int[M];
		for (int i = 0; i < M; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		int maxCnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				int cnt = 0;
				for (int k = 0; k < M; k++) {
					if ((a[k] == i && b[k] == j) || (b[k] == i && a[k] == j))
						cnt++;
				}

				maxCnt = Math.max(maxCnt, cnt);
			}
		}

		System.out.println(maxCnt);
	}
}