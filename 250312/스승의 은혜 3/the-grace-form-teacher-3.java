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
													.thenComparing((int[] row) -> row[0], Comparator.reverseOrder())
				                    )
				                    .toArray(int[][]::new);

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int price = sortedArr[i][0];
			int del = sortedArr[i][1];

			if (b - (price + del) < 0) {
				if (b - ((price / 2) + del) >= 0)
					cnt++;
				break;
			}

			b -= (price + del);
			cnt++;
		}

		System.out.println(cnt);
	}
}