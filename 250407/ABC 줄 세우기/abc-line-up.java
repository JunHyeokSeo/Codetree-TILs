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
			for (int j = 1; j < n - i; j++) {
				if (arr[i] > arr[j]) {
					char tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}