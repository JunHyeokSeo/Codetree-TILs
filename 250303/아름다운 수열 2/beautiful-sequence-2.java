import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<Integer> setA;
		Set<Integer> setB = new HashSet<>();

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			setB.add(sc.nextInt());
		}

		int cnt = 0;
		for (int i = 0; i <= N - M; i++) {
			setA = new HashSet<>();
			for (int j = i; j < i + M; j++) {
				setA.add(A[j]);
			}
			if (setA.equals(setB))
				cnt++;
		}

		System.out.println(cnt);
	}
}