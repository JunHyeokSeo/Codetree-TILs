import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[2 * n];
		for (int i = 0; i < 2 * n; i++)
			arr[i] = sc.nextInt();

		arr = Arrays.stream(arr).sorted().toArray();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, Math.abs(arr[i] - arr[i + n]));
		}

		System.out.println(min);
	}
}