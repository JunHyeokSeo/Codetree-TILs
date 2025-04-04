import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int tmpX = x % 2 == 0 ? x - 1 : x;
		int half = (1 + tmpX) / 2;

		int dist = 0;
		int time = 0;
		int speed = 0;
		while (dist < x) {
			if (dist < half)
				speed++;
			else if (speed > 1)
				speed--;

			dist += speed;
			time++;
		}

		System.out.println(time);
	}
}