import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int[] arr = str.chars().map(c -> c - '0').toArray();

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1)
				continue;

			arr[i] = 1;

			//최소거리
			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (j == k)
						continue;

					if (arr[j] == 1 && arr[k] == 1)
						minDist = Math.min(minDist, Math.abs(j - k));
				}
			}

			arr[i] = 0;
			ans = Math.max(ans, minDist);
		}

		System.out.println(ans);
	}
}