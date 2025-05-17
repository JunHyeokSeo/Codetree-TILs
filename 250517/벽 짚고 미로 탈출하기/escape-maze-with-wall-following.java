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
		char[][] infLoop = {{'.', '.', '.'}, {'.', '#', '.'}, {'.', '.', '.'}};

		char[][] maze = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				maze[i][j] = line.charAt(j);
			}
		}

		int cnt = 0;
		while (true) {
			int nextR;
			int nextC;

			int rightDir = (dir + 1) % 4;
			int rightR = r + y[rightDir] - 1;
			int rightC = c + x[rightDir] - 1;
			if (isInfLoop(maze, infLoop, rightR, rightC)) {
				System.out.println(-1);
				return;
			}

			//앞이 벽이면 반시계 방향 90도 회전
			int dirCnt = 0;
			while (true) {
				if (dirCnt > 4) {
					System.out.println(-1);
					return;
				}

				nextR = r + y[dir];
				nextC = c + x[dir];

				if (!isRange(nextR, nextC, n) || maze[nextR][nextC] != '#')
					break;

				dir = dir == 0 ? 3 : dir - 1;
				dirCnt++;
			}

			cnt++;
			r = nextR;
			c = nextC;
			if (!isRange(r, c, n))
				break;

			rightDir = (dir + 1) % 4;
			rightR = r + y[rightDir];
			rightC = c + x[rightDir];

			if (maze[rightR][rightC] != '#') {
				dir = rightDir;
				r = rightR;
				c = rightC;
				cnt++;
			}

			rightDir = (dir + 1) % 4;
			rightR = r + y[rightDir] - 1;
			rightC = c + x[rightDir] - 1;

			if (isInfLoop(maze, infLoop, rightR, rightC)) {
				System.out.println(-1);
				return;
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					if (i == r && j == c)
//						System.out.print("☆");
//					else
//						System.out.print(maze[i][j]);
//
//					System.out.print(" ");
//				}
//				System.out.println();
//			}
		}

		System.out.println(cnt);
	}

	public static boolean isRange(int r, int c, int n) {
		return (r >= 0 && r < n && c >= 0 && c < n);
	}

	public static boolean isInfLoop(char[][] maze, char[][] infLoop, int r, int c) {
		if (c < 0 || r < 0 || r + 2 >= maze.length || c + 2 >= maze.length)
			return false;

		for (int i = r; i <= r + 2; i++) {
			for (int j = c; j <= c + 2; j++) {
				if (maze[i][j] != infLoop[i - r][j - c])
					return false;
			}
		}

		return true;
	}
}