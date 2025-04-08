import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] board = new String[10];

		int bx = 0;
		int by = 0;
		int lx = 0;
		int ly = 0;
		int rx = 0;
		int ry = 0;

		for (int i = 0; i < 10; i++) {
			board[i] = sc.next();

			if (board[i].contains("R")) {
				ry = i;
				rx = board[i].indexOf("R");
			}

			if (board[i].contains("B")) {
				by = i;
				bx = board[i].indexOf("B");
			}

			if (board[i].contains("L")) {
				ly = i;
				lx = board[i].indexOf("L");
			}
		}

		if (by == ry && ry == ly) {
			int min = Math.min(bx, lx);
			int max = Math.max(bx, lx);

			if (min <= rx && rx <= max)
				System.out.println(max - min + 1);
		} else if (bx == rx && rx == lx) {
			int min = Math.min(by, ly);
			int max = Math.max(by, ly);

			if (min <= ry && ry <= max)
				System.out.println(max - min + 1);
		} else {
			System.out.println(Math.abs(bx - lx) + Math.abs(by - ly) - 1);
		}
	}
}