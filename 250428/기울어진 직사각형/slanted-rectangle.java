import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[n][n];
		int[] x = {1, -1, -1, 1};
		int[] y = {-1, -1, 1, 1};

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				int tmpY = i;
				int tmpX = j;

				if ((i == 0 && (j == 0 || j == n -1)) || (i == n - 1 && (j == 0 || j == n -1)))
					continue;

				int dir = 0;
				while (dir < 4) {
					if (tmpY + y[dir] < 0 || tmpY + y[dir] > n - 1 || tmpX + x[dir] < 0 || tmpX + x[dir] > n - 1) {
						dir++;
					} else {
						sum += grid[tmpY][tmpX];
						tmpY += y[dir];
						tmpX += x[dir];
					}
				}

				if (tmpY == i && tmpX == j) {
					maxSum = Math.max(maxSum, sum);
				}
			}
		}

		System.out.println(maxSum);
	}
}