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
				int calcY = i;
				int calcX = j;
				int maxWidth = 0;
				while (--calcY >= 0 && --calcX >= 0)
					maxWidth++;

				if (maxWidth == 0)
					continue;

				int turnY = i;
				int turnX = j;
				int maxY = i;
				int maxX = j;
				int max = 0;
				while (--turnY >= 0 && ++turnX < n) {
					int tmpSum = 0;

					for (int k = 1; k <= maxWidth; k++) {
						if (turnY - k < 0 || turnX - k < 0)
							break;

						tmpSum += grid[turnY - k][turnX - k];
					}

					if (tmpSum >= max) {
						max = tmpSum;
						maxY = turnY;
						maxX = turnX;
					}
				}

				while (dir < 4 && (dir != 3 || tmpY != i || tmpX != j)) {
					if ((dir == 0 && tmpY == maxY && tmpX == maxX)|| tmpY + y[dir] < 0 || tmpY + y[dir] > n - 1 || tmpX + x[dir] < 0 || tmpX + x[dir] > n - 1) {
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