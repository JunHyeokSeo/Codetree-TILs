import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt() - 1;
		int[] nums = new int[n];
				for (int i = 0; i < n; i++)
					nums[i] = sc.nextInt();

		// 벽 초기화
		int[] wall = new int[m];

		int minMax = Integer.MAX_VALUE;
		while (wall[0] != n - 1) {
			int pos = 0;
			wall[m - 1]++;
			for (int i = m - 1; i >= 0; i--) {
				if (i != m - 1 && pos == 1)
					wall[i]++;

				pos = wall[i] / n;
				wall[i] = wall[i] % n;
			}
			Set<Integer> set = Arrays.stream(wall).boxed().collect(Collectors.toSet());
			if (wall.length != set.size())
				continue;

			boolean isAvailable = true;
			for (int i = 0; i < m - 1; i++) {
				if (wall[i] > wall[i + 1]) {
					isAvailable = false;
					break;
				}
			}

			if (!isAvailable)
				continue;

			if (wall[0] == 0) {
				continue;
			}

			// 그룹별 최대값
			int max = 0;
			int last = 0;
			for (int i = 0; i <= wall.length; i++) {
				int sum = 0;
				int end = i == wall.length ? n : wall[i];
				for (int j = last; j < end; j++) {
					sum += nums[j];
				}

				if (i != wall.length)
					last = wall[i];

				max = Math.max(max, sum);
			}

			minMax = Math.min(minMax, max);
		}

		System.out.println(minMax);
	}
}