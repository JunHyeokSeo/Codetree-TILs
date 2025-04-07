import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		int ab = Math.abs(A - B);
		int axyb = Math.abs(A - x) + Math.abs(B - y);
		int ayxb = Math.abs(A - y) + Math.abs(B - x);
		int min = Math.min(ab, Math.min(axyb, ayxb));

		System.out.println(min);
	}
}