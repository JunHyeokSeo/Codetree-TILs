import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int tmpB = b;
			for (int j = 0; j < n; j++) {
				tmpB -= p[j];

				if (i == j)
					tmpB += (p[j] / 2);

				if (tmpB < 0)
					break;

				cnt++;
			}
			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}