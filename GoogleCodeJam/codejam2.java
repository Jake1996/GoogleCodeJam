package GoogleCodeJam;

import java.util.Scanner;

public class codejam2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int R, C, h[][], w[][];
			R = in.nextInt();
			C = in.nextInt();
			h = new int[R][C];
			w = new int[R][C];
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++) {
					h[i][j] = in.nextInt();
					w[i][j] = h[i][j];
				}
			boolean change = true;
			while (change) {
				for (int i = 1; i < R - 1; i++)
					for (int j = 1; j < C - 1; j++) {

					}

			}

			System.out.println("Case #" + (temp - tc) + ": " + compare(h, w));
		}
		in.close();

	}

	public static int compare(int h[][], int w[][]) {
		int count = 0;
		for (int i = 0; i < h.length; i++)
			for (int j = 0; j < h[i].length; j++) {
				count += w[i][j] - h[i][j];
			}
		return count;
	}

}
