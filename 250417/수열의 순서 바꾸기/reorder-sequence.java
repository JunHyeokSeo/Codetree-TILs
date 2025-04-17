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
			boolean overN = false;
			boolean findBigger = false;
			int replaceIdx = 1;

			while (replaceIdx < n) {
				if (overN) {
					if (arr[replaceIdx] > arr[0])
						findBigger = true;
				} else if (arr[replaceIdx] == n)
					overN = true;

				if (overN && findBigger)
					break;

				replaceIdx++;
			}
			replaceIdx--;

			for (int i = 1; i <= replaceIdx; i++) {
				int idx = i - 1;
				arr[idx] = arr[i];
			}
			arr[replaceIdx] = firstItemInArr;
			cnt++;
		}

		System.out.println(cnt);
	}
}