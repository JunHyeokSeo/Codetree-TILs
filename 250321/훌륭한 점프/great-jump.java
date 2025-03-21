import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = Math.max(arr[0], arr[n - 1]); i <= 100; i++) {
			int lastIdx = 0;
			boolean success = true;
			for (int j = 0; j < n; j++) {
				if (arr[j] < i)
					continue;

				if (j - lastIdx > k) {
					success = false;
					break;
				}
				lastIdx = j;
			}

			if (success) {
				System.out.println(i);
				break;
			}
		}
	}
}