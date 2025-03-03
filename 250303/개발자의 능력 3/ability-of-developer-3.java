import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ability = new int[6];
		for (int i = 0; i < 6; i++) {
			ability[i] = sc.nextInt();
		}

		int totSum = 0;
		for (int i = 0; i < 6; i++) {
			totSum += ability[i];
		}

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				for (int k = j + 1; k < 6; k++) {
					int sum1 = ability[i] + ability[j] + ability[k];
					int sum2 = totSum - sum1;
					int diff = Math.abs(sum1 - sum2);

					minDiff = Math.min(minDiff, diff);
				}
			}
		}

		System.out.println(minDiff);
	}
}