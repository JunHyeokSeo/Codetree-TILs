import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int ans = Integer.MAX_VALUE;
	static List<Integer> list = new ArrayList<>();
	static String[][] grid;
	static int[] numRow = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	static int[] numCol = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		grid = new String[n][n];
		for (int row = 0; row < n; row++) {
			String str = sc.next();
			for (int col = 0; col < str.length(); col++) {
				String c = String.valueOf(str.charAt(col));
				grid[row][col] = c;
				if (!c.equals("S") && !c.equals("E") && !c.equals(".")) {
					numRow[Integer.parseInt(c)] = row;
					numCol[Integer.parseInt(c)] = col;
				} else if (c.equals("S")) {
					numRow[0] = row;
					numCol[0] = col;
				} else if (c.equals("E")) {
					numRow[10] = row;
					numCol[10] = col;
				}
			}
		}

		f(0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	public static void f(int prevNum) {
		for (int i = prevNum + 1; i <= 9; i++) {
			if (numRow[i] == -1)
				continue;

			list.add(i);
			//이동 거리 계산
			if (list.size() >= 3)
				ans = Math.min(ans, getDist());
			f(i);
			list.remove(list.size() - 1);
		}
	}

	public static int getDist() {
		int dist = 0;

		//start to 0원소와 거리계산 + size -1 원소와 end 거리 계산
		int firstNum = list.get(0);
		int firstNumRow = numRow[firstNum];
		int firstNumCol = numCol[firstNum];
		int lastNum = list.get(list.size() - 1);
		int lastNumRow = numRow[lastNum];
		int lastNumCol = numCol[lastNum];
		dist += Math.abs(numRow[0] - firstNumRow) + Math.abs(numCol[0] - firstNumCol);
		dist += Math.abs(numRow[10] - lastNumRow) + Math.abs(numCol[10] - lastNumCol);


		for (int i = 0; i < list.size() - 1; i++) {
			int a = list.get(i);
			int b = list.get(i + 1);
			dist += Math.abs(numRow[a] - numRow[b]) + Math.abs(numCol[a] - numCol[b]);
		}

		return dist;
	}
}