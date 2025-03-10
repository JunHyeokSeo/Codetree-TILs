import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[k][n];
		int[][] arrR = new int[n + 1][n + 1];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 결과 저장
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = j + 1; l < n; l++) {
					arrR[arr[i][j]][arr[i][l]]++;

					if (arrR[arr[i][j]][arr[i][l]] == k)
						cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}