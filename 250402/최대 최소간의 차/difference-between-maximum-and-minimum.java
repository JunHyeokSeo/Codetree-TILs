import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 1; i <= max; i++) {
			int low = i;
			int high = i + k;
			int cost = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] < low)
					cost += Math.abs(low - arr[j]);
				else if (arr[j] > high)
					cost += Math.abs(high - arr[j]);
			}
			minCost = Math.min(minCost, cost);
		}

		System.out.println(minCost);
	}
}