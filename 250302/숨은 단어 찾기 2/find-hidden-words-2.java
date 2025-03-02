import java.util.Scanner;

public class Main {
	public static int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
	public static int[] dy = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};
	public static int DIR_NUM = 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] arr = new String[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = String.valueOf(line.charAt(j));
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < DIR_NUM; k++) {
					if (!(i + dx[k] * 2 >= 0 && i + dx[k] * 2 < n && j + dy[k] * 2 >= 0 && j + dy[k] * 2 < m))
						continue;

					if (arr[i][j].equals("L") && arr[i + dx[k]][j + dy[k]].equals("E") && arr[i + dx[k] * 2][j + dy[k] * 2].equals("E"))
						cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}