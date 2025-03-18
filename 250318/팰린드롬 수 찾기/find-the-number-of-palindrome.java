import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int cnt = 0;
		for (int i = x; i <= y; i++) {
			String s = String.valueOf(i);
			String rs = new StringBuilder(s).reverse().toString();
			if (s.equals(rs))
				cnt++;
		}

		System.out.println(cnt);
	}
}