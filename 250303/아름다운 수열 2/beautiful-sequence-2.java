import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Map<Integer, Integer> mapA;
		Map<Integer, Integer> mapB = new HashMap<>();

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			mapB.put(sc.nextInt(), 0);
		}

		int cnt = 0;
		for (int i = 0; i <= N - M; i++) {
			mapA = new HashMap<>();
			for (int j = i; j < i + M; j++) {
				mapA.put(mapA.get(A[j]), mapA.get(A[j]) == null ? 0 : mapA.get(A[j]) + 1);
			}
			if (mapA.equals(mapB))
				cnt++;
		}

		System.out.println(cnt);
	}
}