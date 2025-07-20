import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int h;
	static int m;
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static int[][] a;
	static int[][] step;
	static int[][] stepForPeople;
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 배열 초기화
		a = new int[n][n];
		step = new int[n][n];
		stepForPeople = new int[n][n];
		visited = new boolean[n][n];

		// 2차원 배열 입력 처리
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		findSaveArea();
		print();
	}

	public static void print() {
		for (int[] stepForPerson : stepForPeople) {
			for (int forPerson : stepForPerson) {
				System.out.print(forPerson + " ");
			}
			System.out.println();
		}
	}

	public static void init() {
		step = new int[n][n];
		visited = new boolean[n][n];
	}

	public static void findSaveArea() {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (a[row][col] != 2)
					continue;

				init();
				push(row, col, 0);
				Pair pair = bfs();
				if (pair == null) {
					stepForPeople[row][col] = -1;
				} else {
					stepForPeople[row][col] = step[pair.row][pair.col];
				}
			}
		}
	}

	public static Pair bfs() {
		while (!queue.isEmpty()) {
			Pair currV = queue.poll();

			if (a[currV.row][currV.col] == 3) {
				queue.clear();
				return currV;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = currV.row + y[i];
				int nextCol = currV.col + x[i];

				if (canGo(nextRow, nextCol)) {
					push(nextRow, nextCol, step[currV.row][currV.col] + 1);
				}
			}
		}

		return null;
	}

	public static boolean canGo(int row, int col) {
		if (!inRange(row, col))
			return false;
		if (a[row][col] == 1)
			return false;
		return !visited[row][col];
	}

	public static boolean inRange(int row, int col) {
		return !(row < 0 || row > n - 1 || col < 0 || col > n - 1);
	}

	public static void push(int row, int col, int stepNum) {
		queue.add(new Pair(row, col));
		visited[row][col] = true;
		step[row][col] = stepNum;
	}

	public static class Pair {
		int row, col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}