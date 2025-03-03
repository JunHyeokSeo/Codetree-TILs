import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		String[] arr = new String[10001];

		for (int i = 0; i < n; i++) {
			int pos = sc.nextInt();
			arr[pos] = sc.next().trim();
		}

		int maxSum = 0;
		for (int i = 1; i < 10001 - k; i++) {
			int sum = 0;
			for (int j = i; j <= i + k; j++) {
				if (arr[j] != null)
					sum += arr[j].equals("H") ? 2 : 1;
			}
			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}