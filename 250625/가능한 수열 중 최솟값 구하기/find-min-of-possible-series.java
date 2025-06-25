import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static boolean flag = true;
	public static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new ArrayList<>();

		f(0);
	}

	public static void f(int index) {
		if (index == n) {
			if (flag) {
				for (Integer i : list)
					System.out.print(i);
				flag = false;
			}
			return;
		}

		for (int num = 4; num <= 6; num++) {
			//진입 전에 가능한 수열인지 테스트
			list.add(num);
			if (flag && canNum())
				f(index + 1);
			list.remove(list.size() - 1);
		}
	}

	public static boolean canNum() {
		boolean canNum = true;

		for (int i = 1; i <= list.size() / 2; i++) {
			boolean same = true;
			int idxOriginStr = list.size() - i;
			int idxCloseStr = idxOriginStr - i;
			for (int j = 0; j < i; j++) {
				if (!list.get(idxOriginStr + j).equals(list.get(idxCloseStr + j))) {
					same = false;
					break;
				}
			}

			//같은게 하나라도 있으면
			if (same)
				canNum = false;
		}

		return canNum;
	}
}