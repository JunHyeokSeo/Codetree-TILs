import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int cnt = 0;
		for (int i = x; i <= y; i++) {
			String s = String.valueOf(i);
			int l = 0;
			int r = s.length() - 1;

			while (l <= r) {
				if (l == r || (l + 1 == r && s.charAt(l) == s.charAt(r))){
					cnt++;
					break;
				}

				if (s.charAt(l) != s.charAt(r))
					break;

				l++;
				r--;
			}
		}

		System.out.println(cnt);
	}
}