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
			int v = sc.nextInt();
			mapB.put(v, mapB.get(v) == null ? 1 : mapB.get(v) + 1);
		}

		int cnt = 0;
		for (int i = 0; i <= N - M; i++) {
			mapA = new HashMap<>();
			for (int j = i; j < i + M; j++) {
				mapA.put(A[j], mapA.get(A[j]) == null ? 1 : mapA.get(A[j]) + 1);
			}
			if (mapA.equals(mapB))
				cnt++;
		}

		System.out.println(cnt);
	}
}