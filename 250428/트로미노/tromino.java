import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		int maxSum = 0;

		//2번 모양
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= m - 3; j++) {
				int sum = 0;
				for (int k = j; k < j + 3; k++) {
					sum += grid[i][k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= n - 3; j++) {
				int sum = 0;
				for (int k = j; k < j + 3; k++) {
					sum += grid[k][i];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}

		for (int i = 0; i <= n - 2; i++) {
			for (int j = 0; j <= m - 2; j++) {
				for (int k = 0; k < 4; k++) {
					int skipI = k / 2 == 0 ? i : i + 1;
					int skipJ = k % 2 == 0 ? j : j + 1;

					int sum = 0;
					for (int l = i; l < i + 2; l++) {
						for (int o = j; o < j + 2; o++) {
							if (l == skipI && o == skipJ)
								continue;

							sum += grid[l][o];
						}
					}

					maxSum = Math.max(maxSum, sum);
				}
			}
		}

		System.out.println(maxSum);
	}
}