import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int ans = 0;
	static int[] A;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();

		f(0, 0);
		System.out.println(ans);
	}

	public static void f(int index, int cnt) {
		if (index == n) {
			if (cnt == m)
				ans = Math.max(ans, calcXOR());
			return;
		}

		list.add(A[index]);
		f(index + 1, cnt + 1);
		list.remove(list.size() - 1);
		f(index + 1, cnt);
	}

	public static int calcXOR() {
		if (list.size() == 1)
			return list.get(0);

		int xor = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			xor ^= list.get(i);
		}

		return xor;
	}
}