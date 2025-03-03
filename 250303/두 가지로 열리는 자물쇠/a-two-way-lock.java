import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		int a2 = sc.nextInt(), b2 = sc.nextInt(), c2 = sc.nextInt();
		sc.close();

		int count = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (isWithinRange(i, a, n) && isWithinRange(j, b, n) && isWithinRange(k, c, n) || isWithinRange(i, a2, n) && isWithinRange(j, b2, n) && isWithinRange(k, c2, n)) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	private static boolean isWithinRange(int x, int y, int n) {
		int dist = Math.min(Math.abs(x - y), n - Math.abs(x - y));
		return dist <= 2;
	}
}
