import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int correctCnt = 0;
		char[] arr = new char[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().charAt(0);

			if (arr[i] == 'A' + i)
				correctCnt++;
		}

		if (correctCnt == n) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int pivot = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] == 'A' + i) {
					pivot = j;
					break;
				}
			}

			for (int j = pivot; j > i; j--) {
				char tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}