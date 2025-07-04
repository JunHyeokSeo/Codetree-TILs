import java.util.Scanner;
public class Main {
	public static int n;
	public static int ans = 0;
	public static int[][] grid;
	public static boolean[] visitedCol;
	public static int[] colByRow;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visitedCol = new boolean[n];
		colByRow = new int[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		f(0);
		System.out.println(ans);
	}

	public static void f(int row) {
		if (row == n) {
			int sum = 0;
			for (int row = 0; row < n; row++) {
				sum += grid[row][colByRow[row]];
			}

			ans = Math.max(ans, sum);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (visitedCol[col])
				continue;

			visitedCol[col] = true;
			colByRow[row] = col;
			f(row + 1);
			visitedCol[col] = false;
		}
	}
}