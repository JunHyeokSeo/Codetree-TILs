import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		int maxCnt = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			int[] time = new int[1001];
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				for (int k = A[j]; k < B[j]; k++) {
					if (time[k] == 0)
						cnt++;
					time[k]++;
				}
			}

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}