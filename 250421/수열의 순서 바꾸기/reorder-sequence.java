import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] sortedArr = Arrays.stream(arr).sorted().toArray();

		int cnt = 0;
		while (!Arrays.equals(sortedArr, arr)) {
			int firstItemInArr = arr[0];
			int replaceIdx = 2;

			while (replaceIdx < n) {
				int tmp = replaceIdx - 1;

				if (arr[replaceIdx] - arr[tmp] != 1) {
					if (replaceIdx != n - 1) {
						if (arr[replaceIdx + 1] - arr[replaceIdx] == 1)
							replaceIdx--;
					}

					break;
				}

				replaceIdx++;
			}

			if (replaceIdx == n)
				replaceIdx--;

			System.arraycopy(arr, 1, arr, 0, replaceIdx);
			arr[replaceIdx] = firstItemInArr;
			cnt++;
		}

		System.out.println(cnt);
	}
}