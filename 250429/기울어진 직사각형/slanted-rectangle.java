import java.util.Scanner;
public class Main {
	public static int n;
	public static int[][] grid;
	public static int[] x = {1, -1, -1, 1};
	public static int[] y = {-1, -1, 1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k < n; k++) {
					for (int l = 1; l < n; l++) {
						int sum = getSum(i, j, k, l);
						if (sum == 0)
							continue;

						ans = Math.max(ans, sum);
					}
				}
			}
		}

		System.out.println(ans);
	}

	public static int getSum(int i, int j, int k, int l) {
		int tmpI = i;
		int tmpJ = j;
		int[] moveNum = {k, l, k, l};
		int sum = 0;

		for (int m = 0; m < 4; m++) {
			for (int o = 0; o < moveNum[m]; o++) {
				sum += grid[tmpI][tmpJ];
				tmpI += y[m];
				tmpJ += x[m];
				if (tmpI < 0 || tmpI > n - 1 || tmpJ < 0 || tmpJ > n - 1) {
					return 0;
				}
			}
		}

		return sum;
	}
}