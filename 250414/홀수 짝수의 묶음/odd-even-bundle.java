import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		int oddCnt = 0;
		int evenCnt = 0;
		int groupCnt = 0;
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
			if (numbers[i] % 2 == 0)
				evenCnt++;
			else
				oddCnt++;
		}

		while (oddCnt > 0 || evenCnt > 0) {
			if (groupCnt % 2 == 0) {
				// 짝수
				if (evenCnt > 0) {
					groupCnt++;
					evenCnt--;
				} else if (oddCnt >= 2) {
					groupCnt++;
					oddCnt -= 2;
				} else {
					oddCnt--;
					groupCnt--;
				}
			} else {
				// 홀수
				if (oddCnt > 0) {
					oddCnt--;
					groupCnt++;
				} else {
					evenCnt--;
				}
			}
		}

		System.out.println(groupCnt);
	}
}