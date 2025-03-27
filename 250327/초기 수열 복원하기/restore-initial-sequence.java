import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			a[i] = sc.nextInt();


		for (int i = 1; i <= n; i++) {
			int[] arr = new int[n];
			arr[0] = i;
			for (int j = 1; j < n; j++) {
				arr[j] = a[j - 1] - arr[j - 1];
			}

			Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
			if (arr.length == set.size()) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[j] + " ");
				}

				return;
			}
		}
	}
}