import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int k;
	static int snakeLength;
	static int[][] apple;
	static int[][][] snake;
	static int[] x = {0, 0, 1, -1};
	static int[] y = {-1, 1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		apple = new int[n][n];
		// row col
		snakeLength = 1;
		snake = new int[n * n][1][2];
		snake[0][0][0] = 0;
		snake[0][0][1] = 0;

		// 사과 저장
		for (int i = 0; i < m; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			apple[row][col] = 1;
		}

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			char d = sc.next().charAt(0);
			int p = sc.nextInt();

			boolean moveSuccessfully = true;
			for (int j = 0; j < p; j++) {
				cnt++;
				if (!moveSnake(d)) {
					moveSuccessfully = false;
					break;
				}
			}

			if (!moveSuccessfully)
				break;
		}

		System.out.println(cnt);
	}

	public static boolean moveSnake(char d) {
		int moveDirIdx = getMoveDirIdx(d);

		int nextRow = snake[0][0][0] + y[moveDirIdx];
		int nextCol = snake[0][0][1] + x[moveDirIdx];

		if (isOverTheRange(nextRow, nextCol))
			return false;

		if (apple[nextRow][nextCol] == 1) {
			snakeLength++;
			apple[nextRow][nextCol] = 0;
		}

		for (int j = snakeLength - 1; j > 0; j--) {
			snake[j][0][0] = snake[j - 1][0][0];
			snake[j][0][1] = snake[j - 1][0][1];
		}
		snake[0][0][0] = nextRow;
		snake[0][0][1] = nextCol;

		return !isCrashToBodyOfSnake();
	}

	public static int getMoveDirIdx(char d) {
		if (d == 'U')
			return 0;
		else if (d == 'D') {
			return 1;
		} else if (d == 'R') {
			return 2;
		} else
			return 3;
	}

	public static boolean isOverTheRange(int nextRow, int nextCol) {
		return (nextCol < 0 || nextCol > n - 1 || nextRow < 0 || nextRow > n - 1);
	}

	public static boolean isCrashToBodyOfSnake() {
		int nextRow = snake[0][0][0];
		int nextCol = snake[0][0][1];

		for (int i = 1; i < snakeLength; i++) {
			if (snake[i][0][0] == nextRow && snake[i][0][1] == nextCol)
				return true;
		}

		return false;
	}
}