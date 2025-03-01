import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();

		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 2; j++) {
				for (int k = i; k < n; k++) {
					for (int l = i == k ? j + 3 : 0; l < n - 2; l++) {
						maxCnt = Math.max(maxCnt, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[k][l] + arr[k][l + 1] + arr[k][l + 2]);
					}
				}
			}
		}

		System.out.println(maxCnt);
	}
}