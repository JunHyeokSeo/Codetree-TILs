import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

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