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
		if (list.size() < 2)
			return true;

		if (list.get(list.size() - 2).equals(list.get(list.size() - 1)))
			return false;

		//연속 부분수열 성립 확인
		boolean hasFlow = false;
		int strIdx = list.size() - 1;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) - list.get(i - 1) != 1)
				break;

			hasFlow = true;
			strIdx = i - 1;
		}

		if (!hasFlow)
			return true;

		int flowLen = list.size() - strIdx;
		if (strIdx - flowLen < 0)
			return true;

		int idxCloseFlow = strIdx - flowLen;
		int idxOriginFlow = strIdx;
		for (int i = 0; i < flowLen; i++) {
			if (!list.get(idxCloseFlow + i).equals(list.get(idxOriginFlow + i)))
				return true;
		}

		return false;
	}
}