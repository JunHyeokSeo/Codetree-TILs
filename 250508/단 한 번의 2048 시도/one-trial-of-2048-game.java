import java.util.Scanner;

public class Main {
	static int[][] grid = new int[4][4];
	static String dir;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		dir = String.valueOf(sc.next().charAt(0));

		play();
		print();
	}

	public static int getLeftIdx(int row, int str) {
		int idx = str + 1;
		while (idx < 4 && grid[row][idx] == 0)
			idx++;

		return idx;
	}

	public static int getRightIdx(int row, int str) {
		int idx = str - 1;
		while (idx >= 0 && grid[row][idx] == 0)
			idx--;

		return idx;
	}

	public static int getUpIdx(int col, int str) {
		int idx = str + 1;
		while (idx < 4 && grid[idx][col] == 0)
			idx++;

		return idx;
	}

	public static int getDownIdx(int col, int str) {
		int idx = str - 1;
		while (idx >= 0 && grid[idx][col] == 0)
			idx--;

		return idx;
	}

	public static void play() {
		int[][] tmp = new int[4][4];

		if (dir.equals("L")) {
			for (int i = 0; i < 4; i++) {
				int tmpIdx = 0;
				for (int j = 0; j < 4; j++) {
					if (grid[i][j] == 0)
						continue;

					int idx = getLeftIdx(i, j);
					if (idx == 4 || grid[i][j] != grid[i][idx]) {
						tmp[i][tmpIdx++] = grid[i][j];
						grid[i][j] = 0;
					} else {
						tmp[i][tmpIdx++] = grid[i][j] + grid[i][idx];
						grid[i][j] = 0;
						grid[i][idx] = 0;
					}
				}
			}
		} else if (dir.equals("R")) {
			for (int i = 0; i < 4; i++) {
				int tmpIdx = 3;
				for (int j = 3; j >= 0; j--) {
					if (grid[i][j] == 0)
						continue;

					int idx = getRightIdx(i, j);
					if (idx == -1 || grid[i][j] != grid[i][idx]) {
						tmp[i][tmpIdx--] = grid[i][j];
						grid[i][j] = 0;
					} else {
						tmp[i][tmpIdx--] = grid[i][j] + grid[i][idx];
						grid[i][j] = 0;
						grid[i][idx] = 0;
					}
				}
			}
		} else if (dir.equals("U")) {
			for (int i = 0; i < 4; i++) {
				int tmpIdx = 0;
				for (int j = 0; j < 4; j++) {
					if (grid[j][i] == 0)
						continue;

					int idx = getUpIdx(i, j);
					if (idx == 4 || grid[j][i] != grid[idx][i]) {
						tmp[tmpIdx++][i] = grid[j][i];
						grid[j][i] = 0;
					} else {
						tmp[tmpIdx++][i] = grid[j][i] + grid[idx][i];
						grid[j][i] = 0;
						grid[idx][i] = 0;
					}
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int tmpIdx = 3;
				for (int j = 3; j >= 0; j--) {
					if (grid[j][i] == 0)
						continue;

					int idx = getDownIdx(i, j);
					if (idx == -1 || grid[j][i] != grid[idx][i]) {
						tmp[tmpIdx--][i] = grid[j][i];
						grid[j][i] = 0;
					} else {
						tmp[tmpIdx--][i] = grid[j][i] + grid[idx][i];
						grid[j][i] = 0;
						grid[idx][i] = 0;
					}
				}
			}
		}

		grid = tmp;
	}

	public static void print() {
		for (int[] ints : grid) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}
}