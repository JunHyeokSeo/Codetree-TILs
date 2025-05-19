import java.util.Scanner;

public class Main {
	static int[][] dice = {{0, 0, 5, 0}, {1, 4, 6, 3}, {0, 0, 2, 0}};
	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int[][] grid = new int[n][n];
		grid[r][c] = dice[1][2];

		for (int i = 0; i < m; i++) {
			String direction = sc.next().trim();
			int tmpR;
			int tmpC;

			switch (direction) {
				case "L" -> {
					tmpR = r + y[0];
					tmpC = c + x[0];
				}
				case "R" -> {
					tmpR = r + y[1];
					tmpC = c + x[1];
				}
				case "U" -> {
					tmpR = r + y[2];
					tmpC = c + x[2];
				}
				default -> {
					tmpR = r + y[3];
					tmpC = c + x[3];
				}
			}

			if (tmpR < 0 || tmpR > n - 1 || tmpC < 0 || tmpC > n - 1)
				continue;

			moveDice(direction);
			grid[tmpR][tmpC] = dice[1][2];
			r = tmpR;
			c = tmpC;
		}

		int sum = 0;
		for (int[] ints : grid) {
			for (int anInt : ints) {
				sum += anInt;
			}
		}

		System.out.println(sum);
	}

	public static void moveDice(String direction) {
		int[][] newDice = new int[3][4];

		switch (direction) {
			case "U" -> {
				newDice[1][1] = dice[1][1];
				newDice[1][3] = dice[1][3];

				newDice[1][2] = dice[0][2];
				newDice[2][2] = dice[1][2];
				newDice[0][2] = dice[1][0];
				newDice[1][0] = dice[2][2];
			}
			case "D" -> {
				newDice[1][1] = dice[1][1];
				newDice[1][3] = dice[1][3];

				newDice[0][2] = dice[1][2];
				newDice[1][2] = dice[2][2];
				newDice[2][2] = dice[1][0];
				newDice[1][0] = dice[0][2];
			}
			case "L" -> {
				newDice[0][2] = dice[0][2];
				newDice[2][2] = dice[2][2];

				System.arraycopy(dice[1], 0, newDice[1], 1, 3);
				newDice[1][0] = dice[1][3];
			}
			default -> {
				newDice[0][2] = dice[0][2];
				newDice[2][2] = dice[2][2];

				System.arraycopy(dice[1], 1, newDice[1], 0, 3);
				newDice[1][3] = dice[1][0];
			}
		}

		dice = newDice;
	}
}