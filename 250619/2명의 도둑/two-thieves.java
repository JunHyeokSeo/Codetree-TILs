import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static int n;
	public static int m;
	public static int c;
	public static int[][] grid;
	public static List<Integer> comb;
	public static int activeValue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		c = sc.nextInt();
		grid = new int[n][n];
		comb = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int ans = 0;
		for (int row1 = 0; row1 < n; row1++) {
			for (int col1 = 0; col1 <= n - m; col1++) {
				for (int row2 = 0; row2 < n; row2++) {
					for (int col2 = 0; col2 <= n - m; col2++) {
						if (isOverlap(row1, col1, row2, col2))
							continue;

						int totalValue = 0;
						int col1end = col1 + m;
						int col2end = col2 + m;
						int[] row = {row1, row2};
						int[] colStr = {col1, col2};
						int[] colEnd = {col1end, col2end};

						for (int i = 0; i < 2; i++) {
							int rowWeight = 0;
							int rowValue = 0;
							for (int idx = colStr[i]; idx < colEnd[i]; idx++) {
								rowWeight += grid[row[i]][idx];
								rowValue += (int) Math.pow(grid[row[i]][idx], 2);
							}

							//초과
							if (rowWeight > c) {
								backtracking(colStr[i], colEnd[i], row[i]);
								totalValue += activeValue;
								activeValue = 0;
							} else {
								totalValue += rowValue;
							}
						}

						ans = Math.max(ans, totalValue);
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void backtracking(int colIdx, int colEnd, int row) {
		if (colIdx == colEnd) {
			int value = 0;
			int weight = 0;
			for (Integer i : comb) {
				value += (int) Math.pow(grid[row][i], 2);
				weight += grid[row][i];
			}

			if (value > activeValue && weight <= c)
				activeValue = value;

			return;
		}

		comb.add(colIdx);
		backtracking(colIdx + 1, colEnd, row);
		comb.remove((Integer) colIdx);
		backtracking(colIdx + 1, colEnd, row);
	}

	public static boolean isOverlap(int row1, int col1, int row2, int col2) {
		if (row1 != row2)
			return false;

		int col1end = col1 + m - 1;
		int col2end = col2 + m - 1;

		return !(col1end < col2 || col1 > col2end);
	}
}