import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				int tmp = arr[i][j];

				if (tmp == 0)
					continue;

				//가로
				if (j < 15 && arr[i][j + 1] == tmp && arr[i][j + 2] == tmp && arr[i][j + 3] == tmp && arr[i][j + 4] == tmp) {
					System.out.println(tmp);
					System.out.println((i + 1) + " " + (j + 2 + 1));
					return;
				}

				//세로
				if (i < 15 && arr[i + 1][j] == tmp && arr[i + 2][j] == tmp && arr[i + 3][j] == tmp && arr[i + 4][j] == tmp) {
					System.out.println(tmp);
					System.out.println((i + 2 + 1) + " " + (j + 1));
					return;
				}

				//대각 우측
				if (i < 15 && j < 15 && arr[i + 1][j + 1] == tmp && arr[i + 2][j + 2] == tmp && arr[i + 3][j + 3] == tmp && arr[i + 4][j + 4] == tmp) {
					System.out.println(tmp);
					System.out.println((i + 2 + 1) + " " + (j + 2 + 1));
					return;
				}

				//대각 좌측
				if (i < 15 && j > 4 && arr[i + 1][j - 1] == tmp && arr[i + 2][j - 2] == tmp && arr[i + 3][j - 3] == tmp && arr[i + 4][j - 4] == tmp) {
					System.out.println(tmp);
					System.out.println((i + 2 + 1) + " " + (j - 2 + 1));
					return;
				}
			}
		}

		System.out.println(0);
	}
}