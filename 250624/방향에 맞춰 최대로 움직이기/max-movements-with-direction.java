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
		ans = Math.max(ans, depth);

		for (int i = 1; i < n; i++) {
			if (canGo(row + (dy[moveDir[row][col]] * i), col + (dx[moveDir[row][col]] * i), num[row][col]))
				f(depth + 1, row + (dy[moveDir[row][col]] * i), col + (dx[moveDir[row][col]] * i));
		}
	}

	public static boolean canGo(int row, int col, int prevNum) {
		return inRange(row, col) && num[row][col] > prevNum;
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}
}