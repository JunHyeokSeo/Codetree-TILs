import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int[][] p = new int[n][2];
		for(int i = 0; i < n; i++){
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}

		int[][] sortedArr = Arrays
				    .stream(p)
				    .sorted(
						    Comparator
								    .comparingInt((int[] row) -> Arrays.stream(row).sum())
								    .thenComparing((int[] row) -> row[0])
				    )
				    .toArray(int[][]::new);

		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int tmpB = b;
			for (int j = 0; j < n; j++) {
				int price = sortedArr[j][0];
				int delivery = sortedArr[j][1];

				if (i == j)
					price /= 2;

				if (tmpB - (price + delivery) >= 0) {
					tmpB -= (price + delivery);
					cnt++;
				}
			}

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}