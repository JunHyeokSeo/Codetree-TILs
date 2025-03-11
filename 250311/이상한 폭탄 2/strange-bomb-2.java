import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] bombs = new int[n];
		for (int i = 0; i < n; i++) {
			bombs[i] = sc.nextInt();
		}

		int maxBomb = -1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int dis = Math.abs(i - j);

				if (bombs[i] == bombs[j] && dis <= k)
					maxBomb = Math.max(maxBomb, bombs[i]);
			}
		}

		System.out.println(maxBomb);
	}
}