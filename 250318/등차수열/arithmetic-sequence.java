import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			max = Math.max(max, num);

			arr[i] = num;
		}

		int maxCnt = 0;
		for (int i = 1; i < max; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (Math.abs(arr[k] - i) == Math.abs(i - arr[j]))
						cnt++;
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}