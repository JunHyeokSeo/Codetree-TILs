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

		Arrays.sort(arr);

		int max = arr[n - 1] * arr[n - 2] - arr[n - 3];
		if (arr[0] < 0 && arr[1] < 0)
			max = Math.max(max, arr[n - 1] * arr[0] * arr[1]);

		System.out.println(max);
	}
}