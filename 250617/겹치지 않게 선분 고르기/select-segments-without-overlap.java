import java.util.*;

public class Main {
	public static int n;
	public static int[][] segments;
	public static int cnt;
	public static List<Integer> idx;
	public static Set<Integer> idxForSearch;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		segments = new int[n][2];
		cnt = 0;
		idx = new ArrayList<>();
		idxForSearch = new HashSet<>();
		for (int i = 0; i < n; i++) {
			segments[i][0] = sc.nextInt();
			segments[i][1] = sc.nextInt();
		}

		getMaxLineCnt(0);
		System.out.println(cnt);
	}


	public static void getMaxLineCnt(int depth) {
		boolean over = isOver();
		if (over || depth == n) {
			cnt = Math.max(cnt, over ? depth - 1 : depth);
			return;
		}

		for (int i = 0; i < n; i++) {
			//중복 검사
			if (idxForSearch.contains(i))
				continue;

			idx.add(i);
			idxForSearch.add(i);
			getMaxLineCnt(depth + 1);
			idx.remove(idx.size() - 1);
			idxForSearch.remove(i);
		}
	}

	public static boolean isOver() {
		for (int i = 0; i < idx.size(); i++) {
			for (int j = 0; j < idx.size(); j++) {
				if (i == j)
					continue;

				if (!(segments[idx.get(i)][1] < segments[idx.get(j)][0] || segments[idx.get(i)][0] > segments[idx.get(j)][1]))
					return true;
			}
		}

		return false;
	}
}