import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[15];
		int[] tmp = new int[15];
		for (int i = 0; i < 15; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int a = arr[0];
		int b = arr[1];
		for (int c = 1; c <= 40; c++) {
			for (int d = 1; d <= 40; d++) {
				if (c > d)
					continue;

				tmp[0] = a;
				tmp[1] = b;
				tmp[2] = c;
				tmp[3] = d;
				tmp[4] = a + b;
				tmp[5] = b + c;
				tmp[6] = c + d;
				tmp[7] = d + a;
				tmp[8] = a + c;
				tmp[9] = b + d;
				tmp[10] = a + b + c;
				tmp[11] = a + b + d;
				tmp[12] = a + c + d;
				tmp[13] = b + c + d;
				tmp[14] = a + b + c + d;
				Arrays.sort(tmp);

				if (Arrays.equals(arr, tmp)){
					System.out.println(a + " " + b + " " + c + " " + d);
					return;
				}
			}
		}
	}
}