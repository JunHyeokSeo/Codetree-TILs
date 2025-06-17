import java.util.*;

public class Main {
	public static int n;
	public static int[][] segments;
	public static int cnt;
	public static int[] idxArr;
	public static int size;
	public static Set<Integer> idxForSearch;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		segments = new int[n][2];
		cnt = 0;
		idxArr = new int[n];
		size = 0;

		idxForSearch = new HashSet<>();
		for (int i = 0; i < n; i++) {
			segments[i][0] = sc.nextInt();
			segments[i][1] = sc.nextInt();
		}

		getMaxLineCnt(0);
		System.out.println(cnt);
	}


	public static void getMaxLineCnt(int depth) {
		boolean over = isOver(depth);
		if (over || depth == n) {
			cnt = Math.max(cnt, over ? depth - 1 : depth);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (idxForSearch.contains(i))
				continue;

			idxArr[depth] = i;
			idxForSearch.add(i);
			getMaxLineCnt(depth + 1);
			idxForSearch.remove(i);
		}
	}

	public static boolean isOver(int depth) {
		if (depth <= 1)
			return false;

		for (int i = 0; i < depth - 1; i++) {
			if (!(segments[idxArr[depth - 1]][1] < segments[idxArr[i]][0] || segments[idxArr[depth - 1]][0] > segments[idxArr[i]][1]))
				return true;
		}

		return false;
	}
}