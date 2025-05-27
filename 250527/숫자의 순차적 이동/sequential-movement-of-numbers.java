import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int[][] grid;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		for (int i = 0; i < m; i++) {
			turn();
		}

		print();
	}

	public static void turn() {
		int[] x = {0, 0, -1, 1, -1, 1, -1, 1};
		int[] y = {-1, 1, 0, 0, -1, -1, 1, 1};

		for (int num = 1; num <= n * n; num++) {
			boolean isChanged = false;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (grid[row][col] != num || isChanged)
						continue;

					int dir = 0;
					int max = 0;
					for (int i = 0; i < 8; i++) {
						int newRow = row + y[i];
						int newCol = col + x[i];

						if (newRow < 0 || newRow > n - 1 || newCol < 0 || newCol > n - 1)
							continue;

						if (grid[newRow][newCol] > max) {
							dir = i;
							max = grid[newRow][newCol];
						}
					}

					//swap
					int tmp = grid[row][col];
					grid[row][col] = grid[row + y[dir]][col + x[dir]];
					grid[row + y[dir]][col + x[dir]] = tmp;
					isChanged = true;
				}
			}
		}
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