import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] first = new int[n];
		int[] second = new int[n];

		for(int i = 0; i < n; i++){
			first[i] = sc.nextInt();
			second[i] = sc.nextInt();
		}

		int maxScore = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					int score = 0;
					for (int l = 0; l < n; l++) {
						if ((first[l] == i && second[l] == k) || (first[l] == j && second[l] == i) || (first[l] == k && second[l] == j))
							score++;
					}
					maxScore = Math.max(maxScore, score);
				}
			}
		}

		System.out.println(maxScore);
	}
}