import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] split = sc.nextLine().split("");

		int maxInt = -1;
		for (int i = 0; i < split.length; i++) {
			String tmp = split[i];
			split[i] = split[i].equals("0") ? "1" : "0";

			int sum = 0;
			int num = 1;
			for (int j = split.length - 1; j >= 0; j--) {
				sum += Integer.parseInt(split[j]) * num;
				num *= 2;
			}

			split[i] = tmp;
			maxInt = Math.max(maxInt, sum);
		}

		System.out.println(maxInt);
	}
}