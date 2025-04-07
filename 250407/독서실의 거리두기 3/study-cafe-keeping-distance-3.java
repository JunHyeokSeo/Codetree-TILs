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
			if (arr[i] != 1)
				continue;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] != 1)
					continue;

				if (j - i > max) {
					max = j - i;
					str = i;
					end = j;
				}
				break;
			}
		}

		arr[(str + end) / 2] = 1;

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 1)
				continue;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] != 1)
					continue;
				
				minDiff = Math.min(minDiff, j - 1);
				break;
			}
		}

		System.out.println(minDiff);
	}
}