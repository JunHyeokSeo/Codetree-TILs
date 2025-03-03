import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[101];
		for (int i = 0; i < n; i++) {
			int position = sc.nextInt();
			String ch = sc.next();

			arr[position] = ch;
		}

		int maxSize = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = i; j <= 100; j++) {
				boolean onlyHasGorH = true;
				int gCnt = 0;
				int hCnt = 0;
				int left = Integer.MAX_VALUE;
				int right = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					String str = arr[k];
					if (str == null) {
						onlyHasGorH = false;
						continue;
					}

					if (str.equals("G"))
						gCnt++;
					if (str.equals("H"))
						hCnt++;

					left = Math.min(left, k);
					right = Math.max(right, k);
				}

				if (onlyHasGorH || (gCnt == hCnt && gCnt != 0))
					maxSize = Math.max(maxSize, right - left);
			}
		}

		System.out.println(maxSize);
	}
}