package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/90101/dashboard#s=p1&a=1
 * 
 * @author jatin
 *
 */
public class WaterSheds {

	static int result[][];
	static int count = -1;
	static int mat[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			count = -1;
			int H, W;
			H = in.nextInt();
			W = in.nextInt();
			result = new int[H][W];
			mat = new int[H][W];
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++) {
					mat[i][j] = in.nextInt();
					result[i][j] = -1;
				}
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					basin(i, j);
			System.out.println("Case #" + (temp - tc) + ":");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					System.out.print(Character.toString((char) (result[i][j] + 97)) + " ");
				System.out.println();
			}
		}
		in.close();
	}

	public static int basin(int r, int c) { // nWeS
		if (result[r][c] == -1) {
			if (north(r, c) <= west(r, c) && north(r, c) <= east(r, c) && north(r, c) <= south(r, c)) {
				if (north(r, c) >= mat[r][c]) {
					result[r][c] = ++count;
				} else
					result[r][c] = basin(r - 1, c);
			} else if (west(r, c) <= north(r, c) && west(r, c) <= east(r, c) && west(r, c) <= south(r, c)) {
				if (west(r, c) >= mat[r][c]) {
					result[r][c] = ++count;
				} else
					result[r][c] = basin(r, c - 1);

			} else if (east(r, c) <= south(r, c) && east(r, c) <= west(r, c) && east(r, c) <= north(r, c)) {
				if (east(r, c) >= mat[r][c]) {
					result[r][c] = ++count;
				} else
					result[r][c] = basin(r, c + 1);

			} else if (south(r, c) <= north(r, c) && south(r, c) <= west(r, c) && south(r, c) <= east(r, c)) {
				if (south(r, c) >= mat[r][c]) {
					result[r][c] = ++count;
				} else
					result[r][c] = basin(r + 1, c);

			}
		}
		return result[r][c];
	}

	public static int north(int i, int j) {
		if (i - 1 >= 0) {
			return mat[i - 1][j];
		} else
			return Integer.MAX_VALUE;
	}

	public static int west(int i, int j) {
		if (j - 1 >= 0) {
			return mat[i][j - 1];
		} else
			return Integer.MAX_VALUE;
	}

	public static int south(int i, int j) {
		if (i + 1 < mat.length) {
			return mat[i + 1][j];
		} else
			return Integer.MAX_VALUE;
	}

	public static int east(int i, int j) {
		if (j + 1 < mat[i].length) {
			return mat[i][j + 1];
		} else
			return Integer.MAX_VALUE;
	}

}
