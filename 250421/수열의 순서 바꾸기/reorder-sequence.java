import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int idx = n - 1;
		while (idx > 0 && arr[idx - 1] < arr[idx]) {
			idx--;
		}

		System.out.println(idx);
	}
}