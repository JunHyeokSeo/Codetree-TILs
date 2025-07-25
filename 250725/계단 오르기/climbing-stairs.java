import java.util.Scanner;
public class Main {
	static int[] tab;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n <= 3) {
			System.out.println(1);
			return;
		}

		tab = new int[n + 1];
		tab[2] = 1;
		tab[3] = 1;
		dp(n);
		System.out.println(tab[n] % 10007);
	}

	public static void dp(int n) {
		for (int i = 4; i <= n; i++) {
			tab[i] = (tab[i - 2] % 10007) + (tab[i - 3] % 10007);
		}
	}
}