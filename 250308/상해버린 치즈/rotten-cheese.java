import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		int S = sc.nextInt();
		int[][] arrD = new int[N + 1][101];
		int[][] arrS = new int[N + 1][101];
		int[] arrM = new int[M + 1];

		for (int i = 0; i < D; i++) {
			int p = sc.nextInt();
			int m = sc.nextInt();
			int t = sc.nextInt();

			arrD[p][t] = m;
		}
		for (int i = 0; i < S; i++) {
			int p = sc.nextInt();
			int t = sc.nextInt();

			arrS[p][t] = 1;
		}

		// 아픈사람 찾기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arrS[i][j] == 0)
					continue;

				//아픈 시점까지 사람이 먹은 치즈 구하기
				for (int k = 1; k <= j; k++) {
					arrM[arrD[i][k]] = 1;
				}
			}
		}

		//치즈 먹은 모든 사람 구하기
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int midCnt = 0;
			for (int j = 1; j <= 100; j++) {
				for (int k = 1; k <= M; k++) {
					if (arrD[i][j] == arrM[k])
						midCnt++;
				}
			}

			if (midCnt > 0)
				cnt++;
		}

		System.out.println(cnt);
	}
}