import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] *= 2;

			for (int j = 0; j < n; j++) {
				int[] tmp = new int[n - 1];

				int cnt = 0;
				for (int k = 0; k < n; k++) {
					if (j == k)
						continue;
					
					tmp[cnt++] = arr[k];
				}

				int sum = 0;
				for (int k = 0; k < cnt - 1; k++) {
					sum += Math.abs(tmp[k] - tmp[k + 1]);
				}

				minSum = Math.min(minSum, sum);
			}

			arr[i] /= 2;
		}

		System.out.println(minSum);
	}
}