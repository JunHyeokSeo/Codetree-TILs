import java.util.*;

public class Main {
	public static int n;
	public static int[][] segments;
	public static int cnt;
	public static List<Integer> idxList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		segments = new int[n][2];
		cnt = 0;
		idxList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			segments[i][0] = sc.nextInt();
			segments[i][1] = sc.nextInt();
		}

		getMaxLineCnt(0);
		System.out.println(cnt);
	}


	public static void getMaxLineCnt(int depth) {
		if (depth == n) {
			cnt = Math.max(cnt, idxList.size());
			return;
		}

		if (canAdd(depth)) {
			idxList.add(depth);
			getMaxLineCnt(depth + 1);
			idxList.remove(idxList.size() - 1);
		}

		getMaxLineCnt(depth + 1);
	}

	public static boolean canAdd(int idx) {
		for (Integer i : idxList) {
			if (!(segments[i][0] > segments[idx][1] || segments[i][1] < segments[idx][0]))
				return false;
		}

		return true;
	}
}
