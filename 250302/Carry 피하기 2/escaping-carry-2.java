import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int max = -1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int carryCnt = 0;
					int digit = 1;
					for (int l = 0; l < 5; l++) {
						if ((arr[i] / digit) % 10 + (arr[j] / digit) % 10 + (arr[k] / digit) % 10 >= 10)
							carryCnt++;
						digit *= 10;
					}

					if (carryCnt == 0)
						max = Math.max(max, arr[i] + arr[j] + arr[k]);
				}
			}
		}

		System.out.println(max);
	}
}