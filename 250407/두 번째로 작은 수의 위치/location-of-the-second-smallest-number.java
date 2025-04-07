import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int[] arr = Arrays.stream(a).sorted().toArray();
		int first = arr[0];
		int second = 0;
		for (int i = 1; i < N; i++) {
			if (second != 0 && arr[i] == arr[second]) {
				second = 0;
				break;
			}

			if (second == 0 && arr[i] > first) {
				second = i;
			}
		}

		if (second == 0) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (a[i] == arr[second])
				System.out.println(i + 1);
		}
	}
}