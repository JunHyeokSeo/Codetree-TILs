import java.util.Scanner;

public class Main {
	static int n;
	static int[][] grid;
	static int r;
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;

		bomb();
		gravity();
		print();
	}

	// 폭발
	public static void bomb() {
		int power = grid[r][c];
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};

		grid[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < power; j++) {
				int removeY = r + (y[i] * j);
				int removeX = c + (x[i] * j);

				if (removeY > n - 1 || removeY < 0 || removeX > n - 1 || removeX < 0)
					break;

				grid[removeY][removeX] = 0;
			}
		}
	}

	// 중력
	public static void gravity() {
		int[][] tmp = new int[n][n];

		for (int i = 0; i < n; i++) {
			int cnt = n - 1;
			for (int j = n - 1; j >= 0; j--) {
				if (grid[j][i] == 0)
					continue;

				tmp[cnt--][i] = grid[j][i];
			}
		}

		grid = tmp;
	}

	public static void print() {
		for (int[] ints : grid) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}
}