import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int minDis = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i++) {
			int tmpX = x[i];
			int tmpY = y[i];
			x[i] = x[i + 1];
			y[i] = y[i + 1];

			// 총 거리계산
			int sumDis = 0;
			for (int j = 0; j < n - 1; j++) {
				sumDis += Math.abs(x[j] - x[j + 1]) + Math.abs(y[j] - y[j + 1]);
			}

			// 원복
			x[i] = tmpX;
			y[i] = tmpY;

			minDis = Math.min(minDis, sumDis);
		}

		System.out.println(minDis);
	}
}