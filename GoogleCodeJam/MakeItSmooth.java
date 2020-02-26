package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/544101/dashboard#s=p1
 * 
 * @author jatin
 */
public class MakeItSmooth {

	public static int dp[][];
	public static int deleteCost, insertCost, min, n;
	public static int numbers[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			deleteCost = in.nextInt();
			insertCost = in.nextInt();
			min = in.nextInt();
			n = in.nextInt();
			numbers = new int[n];
			for (int i = 0; i < n; i++)
				numbers[i] = in.nextInt();
			dp = new int[n][257];

			for (int index = 0; index < n; index++) {
				dp[index][0] = deleteCost * (index + 1);
				for (int i = 0; i < 256; i++) {
					int minCost = Integer.MAX_VALUE;
					if (index == 0) {
						minCost = Math.min(minCost, deleteCost + insertCost);
						minCost = Math.min(minCost, Math.abs(numbers[index] - i));
					} else {
						minCost = Math.min(minCost, dp[index - 1][index(i)] + deleteCost); // delete current element
						minCost = Math.min(minCost, dp[index - 1][0] + Math.abs(numbers[index] - i)); // delete all and
																										// get required
																										// no
						minCost = Math.min(minCost, dp[index - 1][0] + deleteCost + insertCost); // delete everything
																									// and insert
						if (min == 0)
							minCost = Math.min(minCost, Math.abs(numbers[index] - i) + dp[index - 1][index(i)]);
						else
							for (int j = 0; j < 256; j++) {
								if (min != 0)
									minCost = Math.min(minCost, dp[index - 1][index(j)] + insertCalc(i, j) * insertCost
											+ Math.abs(numbers[index] - i)); // modify and insert multiple
							}
					}
					dp[index][index(i)] = minCost;
				}
			}
			int minCost = Integer.MAX_VALUE;
			minCost = Math.min(deleteCost * (n - 1), minCost);
			for (int i = 0; i < 257; i++) {
				minCost = Integer.min(minCost, dp[n - 1][i]);
			}
			System.out.println("Case #" + (temp - tc) + ": " + minCost);
		}
		in.close();
	}

	public static int index(int x) {
		return x + 1;
	}

	public static int insertCalc(int i, int j) {
		int tempo = Math.abs(j - i);
		double tempo1 = (double) tempo / min;
		tempo = (int) Math.ceil(tempo1);
		tempo--;
		return tempo < 0 ? 0 : tempo;
	}
}
