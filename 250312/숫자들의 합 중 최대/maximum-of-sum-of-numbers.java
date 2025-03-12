import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int maxSum = 0;
		for (int i = x; i <= y; i++) {
			int i0 = i % 10;
			int i1 = (i / 10) % 10;
			int i2 = (i / 100) % 10;
			int i3 = (i / 1000) % 10;
			int i4 = (i / 10000) % 10;
			int sum = i0 + i1 + i2 + i3 + i4;
			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}