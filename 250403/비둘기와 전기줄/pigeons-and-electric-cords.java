import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] pigeon = new int[N];
		int[] moveDir = new int[N];
		for (int i = 0; i < N; i++) {
			pigeon[i] = sc.nextInt();
			moveDir[i] = sc.nextInt();
		}

		int cnt = 0;
		for (int i = 1; i <= 10; i++) {
			int last = -1;
			for (int j = 0; j < N; j++) {
				if (pigeon[j] != i)
					continue;

				if (last == -1) {
					last = moveDir[j];
					continue;
				}

				if (last != moveDir[j]) {
					last = moveDir[j];
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}