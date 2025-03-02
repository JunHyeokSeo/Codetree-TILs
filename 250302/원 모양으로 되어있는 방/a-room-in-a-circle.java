import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int minDis = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sumDis = 0;
			for (int j = 0; j < n; j++) {
				sumDis += arr[(i + j) % n] * j;
			}

			minDis = Math.min(minDis, sumDis);
		}

		System.out.println(minDis);
	}
}