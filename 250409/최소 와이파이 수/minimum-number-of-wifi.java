import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int oneCnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 1)
				oneCnt++;
		}

		if (oneCnt == 0) {
			System.out.println(0);
			return;
		}

		if ((m * 2) + 1 >= n) {
			System.out.println(1);
			return;
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int str = Math.max(i - m, 0);
			int end = Math.min(i + m, n - 1);

			if (arr[str] == 1 && str == i - m) {
				cnt++;
				for (int j = str; j <= end; j++) {
					arr[j] = 0;
				}
			}
		}

		System.out.println(cnt);
	}
}