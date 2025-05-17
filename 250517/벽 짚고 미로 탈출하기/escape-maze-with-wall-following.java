import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		//오른쪽
		int dir = 2;
		//좌상우하
		int[] x = {-1, 0, 1, 0};
		int[] y = {0, -1, 0, 1};

		char[][] maze = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				maze[i][j] = line.charAt(j);
			}
		}

		int strR = r;
		int strC = c;
		int cnt = 0;
		while (true) {
			int nextR;
			int nextC;
			//앞이 벽이면 반시계 방향 90도 회전
			while (true) {
				nextR = r + y[dir];
				nextC = c + x[dir];

				if (!isRange(nextR, nextC, n) || maze[nextR][nextC] != '#')
					break;

				dir = dir == 0 ? 3 : dir - 1;
			}

			cnt++;
			r = nextR;
			c = nextC;
			if (!isRange(r, c, n))
				break;

			if (strR == r && strC == c) {
				System.out.println(-1);
				return;
			}

			int rightDir = (dir + 1) % 4;
			int rightR = r + y[rightDir];
			int rightC = c + x[rightDir];

			if (maze[rightR][rightC] != '#') {
				dir = rightDir;
				r = rightR;
				c = rightC;
				cnt++;
			}

			if (strR == r && strC == c) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(cnt);
	}

	public static boolean isRange(int r, int c, int n) {
		return (r >= 0 && r < n && c >= 0 && c < n);
	}
}