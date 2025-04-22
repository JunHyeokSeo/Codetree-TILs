import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[15];
		for (int i = 0; i < 15; i++) {
			arr[i] = sc.nextInt();
		}

		arr = Arrays.stream(arr).sorted().toArray();
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + (arr[14] - (arr[0] + arr[1] + arr[2])));
	}
}