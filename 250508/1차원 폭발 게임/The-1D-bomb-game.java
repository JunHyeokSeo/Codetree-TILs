import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] bombs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		bombs = new int[n];
		for (int i = 0; i < n; i++) {
			bombs[i] = sc.nextInt();
		}
		int totDelItem;
		do {
			totDelItem = bomb();
			getNewArr(totDelItem);
		} while (totDelItem != 0);

		System.out.println(bombs.length);
		for (int bomb : bombs) {
			System.out.println(bomb);
		}
	}

	public static int bomb() {
		if (bombs.length < m)
			return 0;

		int totDelItem = 0;
		for (int i = 0; i < bombs.length; i++) {
			int cnt = 1;
			for (int j = i + 1; j < bombs.length ; j++) {
				if (bombs[i] == 0 || bombs[i] != bombs[j])
					break;

				cnt++;
			}

			if (cnt < m)
				continue;

			totDelItem += cnt;
			for (int j = 0; j < cnt; j++) {
				bombs[i + j] = 0;
			}
		}

		return totDelItem;
	}

	public static void getNewArr(int totDelItem) {
		if (totDelItem == 0)
			return;

		int[] tmp = new int[bombs.length - totDelItem];
		int idx = 0;
		for (int bomb : bombs) {
			if (bomb == 0)
				continue;

			tmp[idx++] = bomb;
		}

		bombs = tmp;
	}
}