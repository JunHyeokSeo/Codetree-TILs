import java.util.Scanner;
public class Main {
	static int[] tab;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n <= 3) {
			System.out.println(n);
			return;
		}

		tab = new int[n + 1];
		tab[1] = 1;
		tab[2] = 2;
		dp(n);
		System.out.println(tab[n] % 10007);
	}

	public static void dp(int n) {
		for (int i = 3; i <= n; i++) {
			tab[i] = (tab[i - 2] % 10007) + (tab[i - 1] % 10007);
		}
	}
}