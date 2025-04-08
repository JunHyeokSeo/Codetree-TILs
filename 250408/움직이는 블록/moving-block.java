import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] blocks = new int[n];

		int blockSum = 0;
		for (int i = 0; i < n; i++) {
			blocks[i] = sc.nextInt();
			blockSum += blocks[i];
		}

		int avg = blockSum / n;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (blocks[i] > avg)
				cnt += blocks[i] - avg;
		}

		System.out.println(cnt);
	}
}