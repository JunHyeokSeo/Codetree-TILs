import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// 합계 및 평균 구하기
				int sum = 0;
				float avg;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}

				avg = (float) sum / (j - i + 1);

				for (int k = i; k <= j; k++) {
					if (arr[k] == avg) {
						cnt++;
						break;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}