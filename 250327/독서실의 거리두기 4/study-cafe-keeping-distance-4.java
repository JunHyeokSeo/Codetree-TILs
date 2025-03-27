import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String seat = sc.next();
		char[] arr = seat.toCharArray();

		int maxMinDist = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;

				if (arr[i] == '1' || arr[j] == '1')
					continue;

				arr[i] = '1';
				arr[j] = '1';

				int minDist = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						if (arr[k] == '1' && arr[l] == '1')
							minDist = Math.min(minDist, Math.abs(k - l));
					}
				}

				maxMinDist = Math.max(maxMinDist, minDist);

				arr[i] = '0';
				arr[j] = '0';
			}
		}

		System.out.println(maxMinDist);
	}
}