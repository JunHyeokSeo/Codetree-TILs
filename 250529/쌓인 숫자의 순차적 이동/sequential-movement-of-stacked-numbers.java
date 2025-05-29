import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static String[][] grid;
	static int[] x = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] y = {-1, 1, 0, 0, -1, -1, 1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = String.valueOf(sc.nextInt());
			}
		}
		for (int i = 0; i < m; i++) {
			String moveNum = String.valueOf(sc.nextInt());

			// row, col 탐색
			int rowForMove = 0;
			int colForMove = 0;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (grid[row][col] == null)
						continue;

					if (grid[row][col].contains(moveNum)) {
						rowForMove = row;
						colForMove = col;
					}
				}
			}

			if (grid[rowForMove][colForMove] == null)
				continue;

			//8방위 중 최대값의 row, col 구하기
			int maxRow = 0;
			int maxCol = 0;
			int max = 0;
			for (int dir = 0; dir < 8; dir++) {
				int nextRow = rowForMove + y[dir];
				int nextCol = colForMove + x[dir];

				if (nextRow < 0 || nextRow > n - 1 || nextCol < 0 || nextCol > n - 1)
					continue;

				if (grid[nextRow][nextCol] == null)
					continue;

				int maxOfStr = Arrays.stream(grid[nextRow][nextCol].split(" ")).mapToInt(Integer::parseInt).max().orElseThrow(() -> new IllegalArgumentException("입력 문자열에 숫자가 없습니다."));
				if (maxOfStr > max) {
					maxRow = nextRow;
					maxCol = nextCol;
					max = maxOfStr;
				}
			}

			//이동하기
			String strForMove = grid[rowForMove][colForMove];
			int idxForMove = strForMove.indexOf(moveNum) + moveNum.length();
			String partOfStrForMove = strForMove.substring(0, idxForMove);
			String restOfStrForMove = strForMove.substring(idxForMove).trim().isEmpty() ? null : strForMove.substring(idxForMove).trim();
			grid[rowForMove][colForMove] = restOfStrForMove;
			String originMovingPointStr = grid[maxRow][maxCol];
			grid[maxRow][maxCol] = partOfStrForMove + " " +  originMovingPointStr;
		}

		//출력하기
		for (String[] strings : grid) {
			for (String str : strings) {
				if (str == null)
					System.out.println("None");
				else
					System.out.println(str);
			}
		}
	}
}