import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] c = new char[n];
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = sc.next().charAt(0);
			s[i] = sc.nextInt();
		}

		int a = 0;
		int b = 0;
		int compare = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (c[i] == 'A')
				a += s[i];
			else
				b += s[i];

			int tmp = Integer.compare(a, b);
			if (tmp != compare)
				cnt++;
			compare = tmp;
		}

		System.out.println(cnt);
	}
}