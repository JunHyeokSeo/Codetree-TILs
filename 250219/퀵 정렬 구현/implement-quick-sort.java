import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine()); // 첫 번째 줄에서 n 읽기
		int[] arr = Arrays.stream(scanner.nextLine().split(" "))
				            .mapToInt(Integer::parseInt)
				            .toArray();

		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = setPivot(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	private static int setPivot(int[] arr, int left, int right) {
		int i = left - 1;
		int pivot = right;

		for (int j = left; j < right; j++) {
			if (arr[j] < arr[pivot]) {
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}

		i++;
		int tmp = arr[i];
		arr[i] = arr[right];
		arr[right] = tmp;

		return i;
	}
}
