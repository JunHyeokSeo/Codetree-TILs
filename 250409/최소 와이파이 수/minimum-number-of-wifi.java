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
		for (int i = m; i < n - m; i++) {
			int str = i - m;
			int end = i + m;

			boolean hasOne = false;
			for (int j = str; j <= end; j++) {
				if (arr[j] == 1) {
					hasOne = true;
					break;
				}
			}

			if (arr[str] == 1 || (hasOne && end == n - 1)) {
				cnt++;
				for (int j = str; j <= end; j++) {
					arr[j] = 0;
				}
			}
		}

		System.out.println(cnt);
	}
}