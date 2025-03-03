import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] candies = new int[n];
		int[] positions = new int[n];
		for (int i = 0; i < n; i++) {
			candies[i] = sc.nextInt();
			positions[i] = sc.nextInt();
		}

		int maxSum = 0;
		for (int i = 0; i < 100; i++) {
			int l = i - k;
			int r = i + k;

			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (positions[j] >= l && positions[j] <= r)
					sum += candies[j];
			}

			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}