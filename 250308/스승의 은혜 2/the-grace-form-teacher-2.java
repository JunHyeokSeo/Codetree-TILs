import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		Arrays.sort(p);

		int maxCnt = 0;
		int tmpB = b;
		for (int i = 0; i < n; i++) {
			int tmpP = p[i];

			if (tmpB - tmpP < 0)
				tmpP /= 2;

			if (tmpB - tmpP < 0)
				break;

			maxCnt++;
			tmpB -= tmpP;
		}

		System.out.println(maxCnt);
	}
}