import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int p = sc.nextInt();
		char[] c = new char[M];
		int[] u = new int[M];
		int[] chk = new int[N];
		for (int i = 0; i < M; i++) {
			c[i] = sc.next().charAt(0);
			u[i] = sc.nextInt();
		}

		if (u[p - 1] == 0)
			return;

		int tmp = p - 1;
		while (tmp >= 0) {
			if (u[p - 1] != u[tmp - 1])
				break;

			tmp--;
		}

		for (int i = M - 1; i >= tmp; i--) {
			chk[(c[i] - 'A')] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (chk[i] == 0)
				System.out.print( (char) ('A' + i) + " ");
		}
	}
}