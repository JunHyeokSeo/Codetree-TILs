import java.util.Scanner;
public class Main {
	public static int n;
	public static int m;
	public static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++) {
						if (isAllPlus(j, j + l, i, i + k))
							ans = Math.max(ans, (l + 1) * (k + 1));
					}
				}
			}
		}

		System.out.println(ans);
	}

	public static boolean isAllPlus(int x1, int x2, int y1, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (i > n - 1 || j > m - 1 || grid[i][j] < 0)
					return false;
			}
		}

		return true;
	}
}