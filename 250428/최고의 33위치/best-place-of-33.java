import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		int maxCnt = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				int cnt = 0;
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						if (grid[k][l] == 1)
							cnt++;
					}
				}

				maxCnt = Math.max(maxCnt, cnt);
			}
		}

		System.out.println(maxCnt);
	}
}