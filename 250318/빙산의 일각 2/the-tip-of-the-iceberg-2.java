import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h = new int[n];
		int maxH = 0;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			maxH = Math.max(maxH, input);
			h[i] = input;
		}

		int maxCnt = 0;
		for (int i = 1; i < maxH; i++) {
			int cnt = 0;
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				if (i <= h[j])
					arr[j] = 1;
			}

			for (int j = 0; j < n - 1; j++) {
				if (j == 0 && arr[j] == 1)
					cnt++;
				if (arr[j] == 0 && arr[j + 1] == 1)
					cnt++;
			}

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}