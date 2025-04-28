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

		int ans = 0;
		for (int i = 0; i <= n; i++) {
			int cost = (i * i) + ((i + 1) * (i + 1));
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int gold = 0;

					// 사각
					for (int l = j - i; l <= j + i; l++) {
						for (int o = k - i; o <= k + i; o++) {
							// 범위 벗어난 것 제외
							if (l < 0 || l > n - 1 || o < 0 || o > n - 1)
								continue;
							// 마름모에 포함 안 되면 제외
							int diff = Math.abs(j - l);
							if (k - i + diff > o || o > k + i - diff)
								continue;

							if (grid[l][o] == 1)
								gold++;
						}
					}

					if (cost <= gold * m)
						ans = Math.max(ans, gold);
				}
			}
		}
		System.out.println(ans);
	}
}