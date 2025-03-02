import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("");

		int cnt = 0;
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equals("(") && str[j].equals(")"))
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}