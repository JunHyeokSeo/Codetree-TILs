import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();

        int ans = 10000;
		for (int i = 1; i <= 10000; i++) {
			boolean isPassable = true;
			int section = 1;
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				if (nums[j] > i) {
					isPassable = false;
					break;
				}

				if (cnt + nums[j] > i) {
					cnt = 0;
					section++;
				}

				cnt += nums[j];
			}

			if (isPassable && section <= m) {
				ans = i;
                break;
			}
		}

        System.out.println(ans);
	}
}