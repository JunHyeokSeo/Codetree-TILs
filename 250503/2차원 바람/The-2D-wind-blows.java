import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static int n;
	static int m;
	static int q;
	static int[][] building;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		building = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				building[i][j] = sc.nextInt();

		for (int i = 0; i < q; i++) {
			int y1 = sc.nextInt() - 1;
			int x1 = sc.nextInt() - 1;
			int y2 = sc.nextInt() - 1;
			int x2 = sc.nextInt() - 1;

			turn(x1, y1, x2, y2);
			avg(x1, y1, x2, y2);
		}

		for (int[] ints : building) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	public static void turn(int x1, int y1, int x2, int y2) {
		int x1y1 = building[y1][x1];
		int x1y2 = building[y2][x1];
		int x2y1 = building[y1][x2];
		int x2y2 = building[y2][x2];

		//top
		for (int i = x2; i > x1; i--) {
			building[y1][i] = building[y1][i - 1];
		}

		//right
		for (int i = y2; i > y1; i--) {
			building[i][x2] = building[i - 1][x2];
		}

		//bottom
		for (int i = x1; i < x2; i++) {
			building[y2][i] = building[y2][i + 1];
		}

		//left
		for (int i = y1; i < y2; i++) {
			building[i][x1] = building[i + 1][x1];
		}

		building[y1][x1 + 1] = x1y1;
		building[y1 + 1][x2] = x2y1;
		building[y2][x2 - 1] = x2y2;
		building[y2 - 1][x1] = x1y2;
	}

	public static void avg(int x1, int y1, int x2, int y2) {
		int[][] tmp = new int[n][m];
		int[] x = {0, 1, 0, -1};
		int[] y = {-1, 0, 1, 0};

		for (int i = 0; i < n; i++) {
			if (m >= 0) System.arraycopy(building[i], 0, tmp[i], 0, m);
		}

		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				int cnt = 1;
				int sum = building[i][j];
				for (int k = 0; k < 4; k++) {
					int tmpI = i + y[k];
					int tmpJ = j + x[k];

					if (tmpI < 0 || tmpI > n - 1 || tmpJ < 0 || tmpJ > m - 1)
						continue;

					cnt++;
					sum += tmp[tmpI][tmpJ];
				}

				building[i][j] = sum / cnt;
			}
		}
	}
}