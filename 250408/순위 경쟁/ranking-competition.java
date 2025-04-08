import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		char[] c = new char[n];
//		int[] s = new int[n];
		int[] score = new int[3];

		String comb = "ABC";

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			char c = sc.next().charAt(0);
			int s = sc.nextInt();

			if (c == 'A')
				score[0] += s;
			else if (c == 'B')
				score[1] += s;
			else
				score[2] += s;

			int max = Math.max(score[0], Math.max(score[1], score[2]));
			StringBuilder newComb = new StringBuilder();
			for (int j = 0; j < 3; j++) {
				if (score[j] == max)
					newComb.append((char) ('A' + j));
			}

			// 명전 조합
			if (!comb.contentEquals(newComb)) {
				cnt++;
				comb = String.valueOf(newComb);
			}
		}

		System.out.println(cnt);
	}
}