import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i <= max; i++) {
			int cost = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] >= i && arr[j] <= (i + 17))
					continue;

				int diff = 0;
				if (arr[j] < i) {
					diff = Math.abs(i - arr[j]);
				} else if (arr[j] > i + 17) {
					diff = Math.abs((i + 17) - arr[j]);
				}

				cost += diff * diff;
			}

			minCost = Math.min(minCost, cost);
		}

		System.out.println(minCost);
	}
}