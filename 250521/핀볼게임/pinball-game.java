import java.util.Scanner;
public class Main {
	static int n;
	static int[][] grid;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};

	//현재 dir로 와서 부딪혔을 때 발생하게 되는 dir
	static int[] dirTouch1 = {3, 2, 1, 0};
	static int[] dirTouch2 = {2, 3, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int maxCnt = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				for (int dir = 0; dir < 4; dir++) {
					int moveCnt = moveBall(row, col, dir);
					maxCnt = Math.max(maxCnt, moveCnt);
				}
			}
		}

		System.out.println(maxCnt);
	}

	public static int moveBall(int row, int col, int dir) {
		// 각 테두리에서 시작한 것이 아니면 return 0
		if (!isOverTheRange(row - y[dir], col - x[dir]))
			return 0;

		int cnt = 1;

		while (true) {
			int nextRow = row + y[dir];
			int nextCol = col + x[dir];
			cnt++;

			if (isOverTheRange(nextRow, nextCol))
				return cnt;

			//무한루프를 고려해서 n * n 이상이 되면 return 0
			if (cnt > n * n)
				return 0;

			if (grid[nextRow][nextCol] == 1)
				dir = dirTouch1[dir];
			else if (grid[nextRow][nextCol] == 2)
				dir = dirTouch2[dir];

			row = nextRow;
			col = nextCol;
		}
	}

	public static boolean isOverTheRange(int row, int col) {
		return row < 0 || row > n - 1 || col < 0 || col > n - 1;
	}
}