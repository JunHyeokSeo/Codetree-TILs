import java.util.Scanner;
public class Main {
	static int n;
	static int t;
	static int[] l;
	static int[] r;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		l = new int[n];
		r = new int[n];
		d = new int[n];

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			r[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			d[i] = sc.nextInt();
		}

		for (int i = 0; i < t; i++)
			swap();

		print(l);
		print(r);
		print(d);
	}

	public static void swap() {
		int rearL = l[n - 1];
		int rearR = r[n - 1];
		int rearD = d[n - 1];

		for (int i = n - 1; i > 0; i--) {
			l[i] = l[i - 1];
		}
		for (int i = n - 1; i > 0; i--) {
			r[i] = r[i - 1];
		}
		for (int i = n - 1; i > 0; i--) {
			d[i] = d[i - 1];
		}

		l[0] = rearD;
		r[0] = rearL;
		d[0] = rearR;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}