import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt() - 1;
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// 첫번째 행에 막대 입력
		for (int i = k; i < k + m; i++) {
			grid[0][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			boolean canMove = true;
			for (int j = k; j < k + m; j++) {
				if (grid[i][j] == 1) {
					canMove = false;
					break;
				}
			}

			if (!canMove)
				break;

			for (int j = k; j < k + m; j++) {
				grid[i - 1][j] = 0;
				grid[i][j] = 1;
			}
		}

		for (int[] ints : grid) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}
}