package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/544101/dashboard#s=p2&a=2
 * 
 * @author jatin
 */
public class NumberGame {
	public static double phi = 1.61803398875;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int A1, A2, B1, B2;
			A1 = in.nextInt();
			A2 = in.nextInt();
			B1 = in.nextInt();
			B2 = in.nextInt();
			long count = 0;
			for (int j = B1; j <= B2; j++)
				count += winner(A1, A2, j);
			for (int j = A1; j <= A2; j++)
				count += winner(B1, B2, j);

			System.out.println("Case #" + (temp - tc) + ": " + count);
		}
		in.close();
	}

	public static long winner(int a1, int a2, int b) {
		double x = b * phi;
		if (a1 >= Math.ceil(x)) {
			return a2 - a1 + 1;
		}
		if (a2 >= Math.ceil(x)) {
			return 1 + a2 - (int) Math.ceil(x);
		}
		return 0;
	}
}
