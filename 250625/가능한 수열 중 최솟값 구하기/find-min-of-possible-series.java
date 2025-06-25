import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new ArrayList<>();

		f(0);
	}

	public static void f(int index) {
		if (index == n) {
			for (Integer i : list)
				System.out.print(i);
			System.exit(0);
		}

		for (int num = 4; num <= 6; num++) {
			//진입 전에 가능한 수열인지 테스트
			list.add(num);
			if (canNum())
				f(index + 1);
			list.remove(list.size() - 1);
		}
	}

	public static boolean canNum() {
		for (int i = 1; i <= list.size() / 2; i++) {
			int idxOriginStr = list.size() - i;
			int idxCloseStr = idxOriginStr - i;

			if (isEquals(idxOriginStr, idxCloseStr))
				return false;
		}

		return true;
	}

	public static boolean isEquals(int idxOriginStr, int idxCloseStr) {
		for (int i = 0; i < idxOriginStr - idxCloseStr; i++) {
			if (!list.get(idxOriginStr + i).equals(list.get(idxCloseStr + i)))
				return false;
		}
		return true;
	}
}