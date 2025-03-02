import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("");

		int cnt = 0;
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length - 1; j++) {
				String strI = str[i] + str[i + 1];
				String strJ = str[j] + str[j + 1];
				if (strI.equals("((") && strJ.equals("))"))
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}