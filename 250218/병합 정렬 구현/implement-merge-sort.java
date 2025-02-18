import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine()); // 첫 번째 줄에서 n 읽기
		int[] arr = Arrays.stream(scanner.nextLine().split(" "))
				            .mapToInt(Integer::parseInt)
				            .toArray();

		mergeSort(arr, new int[n], 0, n - 1); // 정렬 실행

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "")); // 출력 포맷 정리
		scanner.close();
	}

	private static void mergeSort(int[] arr, int[] temp, int low, int high) {
		if (low >= high) return;

		int mid = (low + high) / 2;
		mergeSort(arr, temp, low, mid);
		mergeSort(arr, temp, mid + 1, high);
		merge(arr, temp, low, mid, high);
	}

	private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
		System.arraycopy(arr, low, temp, low, high - low + 1); // 원본 배열을 temp에 복사

		int left = low, right = mid + 1, index = low;

		while (left <= mid && right <= high) {
			arr[index++] = (temp[left] <= temp[right]) ? temp[left++] : temp[right++];
		}

		while (left <= mid) arr[index++] = temp[left++]; // 남은 왼쪽 배열 복사
	}
}
