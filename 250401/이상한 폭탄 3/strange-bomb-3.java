import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] bombs = new int[n];
		for (int i = 0; i < n; i++)
			bombs[i] = sc.nextInt();

		int maxCnt = 0;
		int bomb = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = i + 1; j < n; j++) {
				if (bombs[i] == bombs[j] && Math.abs(i - j) <= k)
					cnt++;
			}

			if (cnt == 0)
				continue;

			if (maxCnt < cnt)
				bomb = bombs[i];
			else if (maxCnt == cnt)
				bomb = Math.max(bomb, bombs[i]);

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(bomb);
	}
}