import java.util.Scanner;

public class Main {
	public static final int DEPTH = 6;
	public static int[] numByAlpha = new int[DEPTH];
	public static final char BIAS = 'a';
	public static String str;
	public static int maxValue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		dfs(0);
		System.out.println(maxValue);
	}

	public static void dfs(int depth) {
		if (depth == DEPTH) {
			maxValue = Math.max(maxValue, calcValue());
			return;
		}

		for (int i = 1; i <= 4; i++) {
			numByAlpha[depth] = i;
			dfs(depth + 1);
		}
	}

	public static int calcValue() {
		char[] ca = str.toCharArray();
		Integer result = null;
		for (int i = 0; i < ca.length; i++) {
			if (!isOperator(ca[i]))
				continue;

			int left = result == null ? getNumByIdxArr(ca[i - 1]) : result;
			int right = getNumByIdxArr(ca[i + 1]);
			result = calculate(left, right, ca[i]);
		}

		assert result != null;
		return result;
	}

	public static int calculate(int left, int right, char operator) {
		switch (operator) {
			case '+':
				return left + right;
			case '-':
				return left - right;
			case '*':
				return left * right;
			default:
				return 0;
		}
	}

	public static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*';
	}

	public static int getNumByIdxArr(char c) {
		return numByAlpha[c - BIAS];
	}
}