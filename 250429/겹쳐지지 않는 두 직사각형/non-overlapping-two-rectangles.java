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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int ans = Integer.MIN_VALUE;
		//첫번째 사각형 시작점
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//첫번째 사각형 크기
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++) {
						int ay1 = i;
						int ax1 = j;
						int ay2 = i + k;
						int ax2 = j + l;

						//두번째 사각형 시작점
						for (int o = 0; o < n; o++) {
							for (int p = 0; p < m; p++) {
								//두번째 사각형 크기
								for (int q = 0; q < n; q++) {
									for (int r = 0; r < m; r++) {
										int by1 = o;
										int bx1 = p;
										int by2 = o + q;
										int bx2 = p + r;

										if (isOver(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2))
											continue;

										ans = Math.max(ans, getScore(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

	public static boolean isOver(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		return !(ax2 < bx1 || bx2 < ax1 || ay2 < by1 || by2 < ay1);
	}

	public static int getScore(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int sum = 0;

		for (int i = ay1; i <= ay2; i++) {
			for (int j = ax1; j <= ax2; j++) {
				if (i > n - 1 || j > m - 1)
					return Integer.MIN_VALUE;

				sum += grid[i][j];
			}
		}

		for (int i = by1; i <= by2; i++) {
			for (int j = bx1; j <= bx2; j++) {
				if (i > n - 1 || j > m - 1)
					return Integer.MIN_VALUE;

				sum += grid[i][j];
			}
		}

		return sum;
	}
}