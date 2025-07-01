import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static double ans = Double.MAX_VALUE;
	static List<Point> points = new ArrayList<>();
	static List<Integer> indexList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points.add(new Point(x, y));
		}

		f(0, 0);
		System.out.println((int) Math.pow(ans, 2));
	}

	public static void f(int index, int cnt) {
		if (cnt == m) {
			ans = Math.min(ans, getMaxDistChoosePoint());
			return;
		}

		if (index == n)
			return;

		indexList.add(index);
		f(index + 1, cnt + 1);
		indexList.remove(indexList.size() - 1);

		f(index + 1, cnt);
	}

	public static double getMaxDistChoosePoint() {
		double maxDist = 0;
		for (int i = 0; i < indexList.size(); i++) {
			for (int j = i + 1; j < indexList.size(); j++) {
				maxDist = Math.max(maxDist, points.get(indexList.get(i)).getDist(points.get(indexList.get(j))));
			}
		}

		return maxDist;
	}

	public static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public double getDist(Point point) {
			return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
		}
	}
}