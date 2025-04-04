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

		for (int i = 0; i < N; i++) {
			char person = (char) ('A' + i);

			boolean isRead = false;
			for (int j = 0; j < M; j++) {
				if (u[j] >= u[p - 1] && c[j] == person)
					isRead = true;
			}

			if (!isRead)
				System.out.print(person + " ");
		}
	}
}