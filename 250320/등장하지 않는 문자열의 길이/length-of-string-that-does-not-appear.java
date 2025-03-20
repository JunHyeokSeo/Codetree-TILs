import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();

		for (int i = 1; i <= n; i++) {
			boolean success = true;

			for (int j = 0; j <= n - i; j++) {
				for (int k = j + 1; k <= n - i; k++) {
					if (str.substring(j, j + i).equals(str.substring(k, k + i))) {
						success = false;
						break;
					}
				}
			}

			if (success) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}
}