import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		int S = sc.nextInt();

		int[] arrM = new int[M + 1];
		int[] arrDP = new int[D + 1];
		int[] arrDM = new int[D + 1];
		int[] arrDT = new int[D + 1];
		int[] arrSP = new int[S + 1];
		int[] arrST = new int[S + 1];

		for (int i = 1; i <= D; i++) {
			int p = sc.nextInt();
			int m = sc.nextInt();
			int t = sc.nextInt();

			arrDP[i] = p;
			arrDM[i] = m;
			arrDT[i] = t;
		}

		for (int i = 1; i <= S; i++) {
			int p = sc.nextInt();
			int t = sc.nextInt();

			arrSP[i] = p;
			arrST[i] = t;
		}

		// 아픈사람 찾기
		for (int i = 1; i <= S; i++) {
			int sp = arrSP[i];
			int st = arrST[i];

			// 아픈 사람이 먹은 치즈 찾기
			for (int j = 1; j <= D; j++) {
				int dp = arrDP[j];
				int dm = arrDM[j];
				int dt = arrDT[j];

				if (sp == dp && dt < st)
					arrM[dm] = 1;
			}
		}

		//아픈 치즈 먹은 모든 사람 검거
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int midCnt = 0;
			for (int j = 1; j <= D; j++) {
				if (arrDP[j] != i)
					continue;

				if (arrM[arrDM[j]] == 1)
					midCnt++;
			}

			if (midCnt >= 1)
				cnt++;
		}

		System.out.println(cnt);
	}
}