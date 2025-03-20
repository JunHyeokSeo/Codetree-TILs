import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int loopA = C / A;
		int loopB = C / B;

		int max = 0;
		for (int i = 0; i <= loopA; i++) {
			for (int j = 0; j <= loopB; j++) {
				if (A * i + B * j <= C)
					max = Math.max(max, A * i + B * j);
			}
		}

		System.out.println(max);
	}
}