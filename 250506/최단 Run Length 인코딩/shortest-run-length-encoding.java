import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length(); i++) {
			String tmp = new String(A);

			for (int j = 0; j < i; j++) {
				tmp = shift(tmp);
			}

			min = Math.min(min, cnt(tmp));
		}

		System.out.println(min);
	}

	public static String shift(String a) {
		return a.substring(1) + a.charAt(0);
	}

	public static int cnt(String a) {
		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) != a.charAt(i + 1)) {
				sb.append(a.charAt(i));
				sb.append(cnt);
				cnt = 1;
			} else {
				cnt++;
			}
		}

		sb.append(a.charAt(a.length() - 1));
		sb.append(cnt);

		return sb.toString().length();
	}
}