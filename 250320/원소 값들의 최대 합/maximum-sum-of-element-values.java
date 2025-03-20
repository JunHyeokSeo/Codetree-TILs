import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		int maxSum = 0;
		for (int i = 1; i <= n; i++) {
			int pivot = i;
			int sum = 0;

			for (int j = 0; j < m; j++) {
				sum += arr[pivot];
				pivot = arr[pivot];
			}

			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}