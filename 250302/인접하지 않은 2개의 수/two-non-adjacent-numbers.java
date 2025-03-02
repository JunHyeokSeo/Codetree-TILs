import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}

		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (Math.abs(i - j) >= 2) {
					maxSum = Math.max(maxSum, (arr[i] + arr[j]));
				}
			}
		}

		System.out.println(maxSum);
	}
}