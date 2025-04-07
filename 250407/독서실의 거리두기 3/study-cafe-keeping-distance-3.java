import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seats = sc.next();

		int[] arr = seats
				            .chars()
				            .map(c -> Integer.parseInt(String.valueOf((char) c)))
				            .toArray();
		int str = 0;
		int end = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == 1 && arr[j] == 1) {
					if (Math.abs(i - j) > max) {

						max = Math.abs(i - j);
						str = i;
						end = j;
					}
					break;
				}
			}
		}

		arr[(str + end) / 2] = 1;

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == 1 && arr[j] == 1) {
					minDiff = Math.min(minDiff, Math.abs(i - j));
					break;
				}
			}
		}

		System.out.println(minDiff);
	}
}