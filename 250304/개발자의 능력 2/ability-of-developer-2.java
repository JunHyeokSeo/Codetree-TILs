import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		int totAbility = 0;
		for (int i = 0; i < 6; i++) {
			int ability = sc.nextInt();
			arr[i] = ability;
			totAbility += ability;
		}

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					for (int l = 0; l < 6; l++) {
						if (i == j || i == k || i == l || j == k || j == l || k == l)
							continue;


						int aAbility = arr[i] + arr[j];
						int bAbility = arr[k] + arr[l];
						int cAbility = totAbility - (aAbility + bAbility);

						int max = Math.max(Math.max(aAbility, bAbility), cAbility);
						int min = Math.min(Math.min(aAbility, bAbility), cAbility);
						int diff = max - min;

						minDiff = Math.min(minDiff, diff);
					}
				}
			}
		}

		System.out.println(minDiff);
	}
}