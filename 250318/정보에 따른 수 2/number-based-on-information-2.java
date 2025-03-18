import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		char[] arr = new char[1010];

		for (int i = 0; i < T; i++) {
			char c = sc.next().charAt(0);
			int pos = sc.nextInt();

			arr[pos] = c;
		}

		// a to b
		int cnt = 0;
		for (int i = a; i <= b; i++) {
			//특별한 위치의 수 탐색
			int minS = Integer.MAX_VALUE;
			int minN = Integer.MAX_VALUE;
			for (int j = 0; j <= 1000; j++) {
				if (minS != Integer.MAX_VALUE && minN != Integer.MAX_VALUE)
					break;

				if ((i - j >= 0 && arr[i - j] == 'S') || (i + j <= 1000 && arr[i + j] == 'S'))
					minS = Math.min(minS, j);

				if ((i - j >= 0 && arr[i - j] == 'N') || (i + j <= 1000 && arr[i + j] == 'N'))
					minN = Math.min(minN, j);
			}

			if (minS <= minN)
				cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}
}