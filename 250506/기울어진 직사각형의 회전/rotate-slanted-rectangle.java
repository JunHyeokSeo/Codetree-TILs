import java.util.Scanner;
public class Main {
	public static int n;
	public static int[][] grid;
	public static int r;
	public static int c;
	public static int m1;
	public static int m2;
	public static int m3;
	public static int m4;
	public static int dir;
	public static int[] x = {1, -1, -1, 1};
	public static int[] y = {-1, -1, 1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		dir = sc.nextInt();

		spin();

		for (int[] ints : grid) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	public static void spin() {
		int p1y = r;
		int p1x = c;
		int p2y = p1y - m1;
		int p2x = p1x + m1;
		int p3y = p2y - m2;
		int p3x = p2x - m2;
		int p4y = p3y + m3;
		int p4x = p3x - m3;

		int p1 = grid[p1y][p1x];
		int p2 = grid[p2y][p2x];
		int p3 = grid[p3y][p3x];
		int p4 = grid[p4y][p4x];

		// 반시계
		if (dir == 0) {
			// 1번 방향
			for (int i = 0; i < m1; i++) {
				int currentY = p2y - (y[0] * i);
				int currentX = p2x - (x[0] * i);
				int swapY = p2y - (y[0] * (i + 1));
				int swapX = p2x - (x[0] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			//2번 방향
			for (int i = 0; i < m2; i++) {
				int currentY = p3y - (y[1] * i);
				int currentX = p3x - (x[1] * i);
				int swapY = p3y - (y[1] * (i + 1));
				int swapX = p3x - (x[1] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			//3번 방향
			for (int i = 0; i < m3; i++) {
				int currentY = p4y - (y[2] * i);
				int currentX = p4x - (x[2] * i);
				int swapY = p4y - (y[2] * (i + 1));
				int swapX = p4x - (x[2] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			//4번 방향
			for (int i = 0; i < m4; i++) {
				int currentY = p1y - (y[3] * i);
				int currentX = p1x - (x[3] * i);
				int swapY = p1y - (y[3] * (i + 1));
				int swapX = p1x - (x[3] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			grid[p1y + y[0]][p1x + x[0]] = p1;
			grid[p2y + y[1]][p2x + x[1]] = p2;
			grid[p3y + y[2]][p3x + x[2]] = p3;
			grid[p4y + y[3]][p4x + x[3]] = p4;
		}
		// 시계
		else {
			// 1 to 4
			for (int i = 0; i < m4; i++) {
				int currentY = p4y + (y[3] * i);
				int currentX = p4x + (x[3] * i);
				int swapY = p4y + (y[3] * (i + 1));
				int swapX = p4x + (x[3] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			for (int i = 0; i < m3; i++) {
				int currentY = p3y + (y[2] * i);
				int currentX = p3x + (x[2] * i);
				int swapY = p3y + (y[2] * (i + 1));
				int swapX = p3x + (x[2] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			for (int i = 0; i < m2; i++) {
				int currentY = p2y + (y[1] * i);
				int currentX = p2x + (x[1] * i);
				int swapY = p2y + (y[1] * (i + 1));
				int swapX = p2x + (x[1] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			for (int i = 0; i < m1; i++) {
				int currentY = p1y + (y[0] * i);
				int currentX = p1x + (x[0] * i);
				int swapY = p1y + (y[0] * (i + 1));
				int swapX = p1x + (x[0] * (i + 1));
				grid[currentY][currentX] = grid[swapY][swapX];
			}

			grid[p1y - y[3]][p1x - x[3]] = p1;
			grid[p4y - y[2]][p4x - x[2]] = p4;
			grid[p3y - y[1]][p3x - x[1]] = p3;
			grid[p2y - y[0]][p2x - x[0]] = p2;
		}
	}
}