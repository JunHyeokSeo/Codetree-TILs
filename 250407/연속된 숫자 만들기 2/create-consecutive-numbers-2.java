import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = 0;
		Arrays.sort(arr);
		while (arr[0] - arr[1] != -1 || arr[1] - arr[2] != -1) {
			int ab = Math.abs(arr[0] - arr[1]);
			int bc = Math.abs(arr[1] - arr[2]);

			if (ab < bc && ab != 1) {
				arr[2] = (arr[0] + arr[1]) / 2;
			} else {
				arr[0] = (arr[1] + arr[2]) / 2;
			}

			Arrays.sort(arr);
			cnt++;
		}

		System.out.println(cnt);
	}
}