import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		if ((a >= c && a <= d) || (b >= c && b <= d) || (c >= a && c <= b) || (d >= a && d <= b))
			System.out.println(Math.max(a, Math.max(b, Math.max(c, d))) - Math.min(a, Math.min(b, Math.min(c, d))));
		else
			System.out.println(b - a + d - c);
	}
}