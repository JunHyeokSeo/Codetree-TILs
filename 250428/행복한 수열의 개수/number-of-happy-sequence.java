import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();


		//행
		int cntOfHappy = 0;
		for (int i = 0; i < n; i++) {
			int maxCnt = 0;
			for (int j = 0; j <= n - m; j++) {
				int cnt = 0;
				for (int k = j; k < j + m; k++) {
					if (grid[i][j] == grid[i][k])
						cnt++;
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			if (maxCnt >= m)
				cntOfHappy++;
		}

		//열
		for (int i = 0; i < n; i++) {
			int maxCnt = 0;
			for (int j = 0; j <= n - m; j++) {
				int cnt = 0;
				for (int k = j; k < j + m; k++) {
					if (grid[j][i] == grid[k][i])
						cnt++;
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			if (maxCnt >= m)
				cntOfHappy++;
		}

		System.out.println(cntOfHappy);
	}
}