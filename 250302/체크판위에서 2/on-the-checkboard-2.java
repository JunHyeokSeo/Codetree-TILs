import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		String[][] arr = new String[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.next();
			}
		}

		int cnt = 0;
		for (int i = 1; i < r - 1; i++) {
			for (int j = 1; j < c - 1; j++) {
				for (int k = i + 1; k < r - 1; k++) {
					for (int l = j + 1; l < c - 1; l++) {
						if (!arr[i][j].equals(arr[0][0]) && arr[i][j].equals(arr[r - 1][c - 1]) && arr[k][l].equals(arr[0][0]) && !arr[k][l].equals(arr[r - 1][c - 1]))
							cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}