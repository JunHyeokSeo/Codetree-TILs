import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int q;
	static int[][] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int r = sc.nextInt();
			String d = String.valueOf(sc.next().charAt(0));

			windSimulation(-1, r - 1, d);
		}

		for (int[] ints : a) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	public static void windSimulation(int lastRow, int currentRow, String currentDir) {
		if (currentRow < 0 || currentRow > n - 1)
			return;

		String futureDir = currentDir.equals("L") ? "R" : "L";
		int tmp;
		if (currentDir.equals("R")) {
			tmp = a[currentRow][0];
			for (int i = 0; i < m - 1; i++)
				a[currentRow][i] = a[currentRow][i + 1];
			a[currentRow][m - 1] = tmp;
		} else {
			tmp = a[currentRow][m - 1];
			for (int i = m - 1; i > 0; i--)
				a[currentRow][i] = a[currentRow][i - 1];
			a[currentRow][0] = tmp;
		}

		if (lastRow == -1) {
			if (currentRow - 1 >= 0 && hasSamePositionSameItem(a[currentRow], a[currentRow - 1]))
				windSimulation(currentRow, currentRow - 1, futureDir);
			if (currentRow + 1 <= n - 1 && hasSamePositionSameItem(a[currentRow], a[currentRow + 1]))
				windSimulation(currentRow, currentRow + 1, futureDir);
		} else if (lastRow - currentRow == 1) {
			if (currentRow - 1 >= 0 && hasSamePositionSameItem(a[currentRow], a[currentRow - 1]))
				windSimulation(currentRow, currentRow - 1, futureDir);
		} else {
			if (currentRow + 1 <= n - 1 && hasSamePositionSameItem(a[currentRow], a[currentRow + 1]))
				windSimulation(currentRow, currentRow + 1, futureDir);
		}
	}

	public static boolean hasSamePositionSameItem(int[] arr1, int[] arr2){
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i])
				return true;
		}

		return false;
	}

}