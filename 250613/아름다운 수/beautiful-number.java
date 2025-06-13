import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static List<Integer> list = new ArrayList<>();
	public static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		choose(0, n);
		System.out.println(cnt);
	}

	public static boolean isBeauty() {
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);

			if (i + num > list.size())
				return false;

			for (int j = i + 1; j < i + num; j++) {
				if (num != list.get(j))
					return false;
			}

			i += (num - 1);
		}

		return true;
	}

	public static void choose(int depth, int n) {
		if (depth == n) {
			if (isBeauty())
				cnt++;
			return;
		}

		for (int i = 1; i <= 4; i++) {
			list.add(i);
			choose(depth + 1, n);
			list.remove(list.size() - 1);
		}
	}
}