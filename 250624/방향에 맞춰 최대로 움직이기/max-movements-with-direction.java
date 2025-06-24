import java.util.Scanner;
public class Main {
	static int ans;
	static int n;
	static int r;
	static int c;
	static int[][] num;
	static int[][] moveDir;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		moveDir = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				moveDir[i][j] = sc.nextInt() - 1;
			}
		}
		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;

		f(0, r, c);
		System.out.println(ans);
	}

	public static void f(int depth, int row, int col) {
		if (!canMove(row, col)) {
			ans = Math.max(ans, depth);
			return;
		}

		int curNum = num[row][col];
		for (int i = 1; i < n; i++) {
			int nextRow = row + (dy[moveDir[row][col]] * i);
			int nextCol = col + (dx[moveDir[row][col]] * i);

			if (isOverTheRange(nextRow, nextCol))
				break;

			int nextNum = num[nextRow][nextCol];
			if (nextNum > curNum)
				f(depth + 1, nextRow, nextCol);
		}
	}

	public static boolean canMove(int row, int col) {
		int curNum = num[row][col];
		if (curNum == n * n)
			return false;

		for (int i = 1; i < n; i++) {
			int nextRow = row + (dy[moveDir[row][col]] * i);
			int nextCol = col + (dx[moveDir[row][col]] * i);

			if (isOverTheRange(nextRow, nextCol))
				return false;

			if (num[nextRow][nextCol] > curNum)
				return true;
		}

		return false;
	}

	public static boolean isOverTheRange(int row, int col) {
		return row < 0 || row > n - 1 || col < 0 || col > n - 1;
	}
}