import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] count1 = new int[n];
		int[] count2 = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
			count1[i] = sc.nextInt();
			count2[i] = sc.nextInt();
		}


		int cnt = 0;
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				for (int k = 1; k < 9; k++) {
					if (i == j && j == k)
						continue;

					boolean success = true;
					for (int l = 0; l < n; l++) {
						int x = num[l] / 100;
						int y = (num[l] / 10) % 10;
						int z = num[l] % 10;

						int cnt1 = 0;
						int cnt2 = 0;

						if (i == x)
							cnt1++;
						if (j == y)
							cnt1++;
						if (k == z)
							cnt1++;
						if (i == y || i == z)
							cnt2++;
						if (j == x || j == z)
							cnt2++;
						if (k == x || k == y)
							cnt2++;

						if (cnt1 != count1[l] || cnt2 != count2[l]) {
							success = false;
							break;
						}
					}

					if (success)
						cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}