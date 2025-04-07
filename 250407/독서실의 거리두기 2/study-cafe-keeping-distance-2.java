import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String seats = sc.next();

		int[] arr = seats.chars().map(c -> Integer.parseInt(String.valueOf((char) c))).toArray();
		int maxMinDist = 0;
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				if (arr[0] == 1)
					continue;
				arr[0] = 1;
			} else if (i == 1) {
				if (arr[n - 1] == 1)
					continue;
				arr[n - 1] = 1;
			} else {
				int str = 0;
				int end = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j] != 1)
						continue;
					for (int k = j + 1; k < n; k++) {
						if (arr[k] != 1)
							continue;

						if (end - str < k - j) {
							str = j;
							end = k;
						}

						break;
					}
				}

				arr[(end + str) / 2] = 1;
			}

			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (arr[j] != 1)
					continue;
				for (int k = j + 1; k < n; k++) {
					if (arr[k] != 1)
						continue;
					minDist = Math.min(minDist, k - j);
					break;
				}
			}
			
			maxMinDist = Math.max(maxMinDist, minDist);

			if (i == 0)
				arr[0] = 0;

			if (i == 1)
				arr[n - 1] = 0;
		}

		System.out.println(maxMinDist);
	}
}