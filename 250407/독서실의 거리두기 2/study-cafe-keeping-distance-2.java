import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String seats = sc.next();

		int[] arr = seats.chars().map(c -> Integer.parseInt(String.valueOf((char) c))).toArray();
		int[] tmp1 = Arrays.copyOf(arr, arr.length);
		int[] tmp2 = Arrays.copyOf(arr, arr.length);
		int[] tmp3 = Arrays.copyOf(arr, arr.length);

		tmp1[n - 1] = 1;
		tmp3[0] = 1;

		int str = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 1)
				continue;

			for (int j = i + 1; j < n; j++) {
				if (arr[j] != 1)
					continue;

				if (end - str < j - 1) {
					str = i;
					end = j;
					break;
				}
			}
		}

		tmp2[(str + end) / 2] = 1;

		int ans;
		int tmp2MinDist = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (tmp2[i] != 1)
				continue;

			for (int j = i + 1; j < n; j++) {
				if (tmp2[j] != 1)
					continue;

				tmp2MinDist = Math.min(tmp2MinDist, j - i);
				break;
			}
		}

		ans = tmp2MinDist;

		if (!Arrays.equals(arr, tmp1)) {
			int tmp1MinDist = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (tmp1[i] != 1)
					continue;

				for (int j = i + 1; j < n; j++) {
					if (tmp1[j] != 1)
						continue;

					tmp1MinDist = Math.min(tmp1MinDist, j - i);
					break;
				}
			}
			ans = Math.max(ans, tmp1MinDist);
		}

		if (!Arrays.equals(arr, tmp3)) {
			int tmp3MinDist = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (tmp3[i] != 1)
					continue;

				for (int j = i + 1; j < n; j++) {
					if (tmp3[j] != 1)
						continue;

					tmp3MinDist = Math.min(tmp3MinDist, j - i);
					break;
				}
			}
			ans = Math.max(ans, tmp3MinDist);
		}

		System.out.println(ans);
	}
}