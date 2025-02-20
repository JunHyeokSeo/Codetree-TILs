import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());  // 첫 번째 줄에서 n 읽기
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		heapSort(arr, n);

		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static void heapSort(int[] arr, int n) {
		// 1. Max Heap 구성 (heapify 적용)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// 2. 정렬 수행 (루트 노드와 마지막 노드 교환 후 heapify 적용)
		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i); // 최대값(루트)과 마지막 원소 교환
			heapify(arr, i, 0); // 감소된 힙 크기에 대해 heapify 적용
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;  // 루트 노드
		int left = 2 * i + 1;  // 왼쪽 자식 노드
		int right = 2 * i + 2; // 오른쪽 자식 노드

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {  // 루트가 최대값이 아니라면 교환
			swap(arr, i, largest);
			heapify(arr, n, largest);  // 재귀적으로 heapify 적용
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
