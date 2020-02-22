package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/635101/dashboard#s=p2
 * 
 * @author jake
 *
 */
public class YourRankIsPure {
	public final static int mod = 100003;
	public static int C[][] = new int[501][501];
	public static int table[][] = new int[501][501];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i <= 500; i++) {
			C[i][0] = 1;
		}
		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= i; j++) {
				C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % 100003;
			}
		}
		for (int i = 0; i < 501; i++)
			table[i][0] = 1;
		int tc = in.nextInt();
		int temp = tc;
		int n;
		while (tc-- != 0) {
			n = in.nextInt();
			System.out.println("Case #" + (temp - tc) + ": " + ans(n));
		}
		in.close();

	}

	public static int ans(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += dp(n, i) % mod;
			sum = sum % mod;
		}
		return sum;
	}

	public static int dp(int i, int j) {
		if (i <= j)
			return 0;
		if (j == 1)
			return 1;
		if (table[i][j] == 0) {
			long sum = 0;
			for (int k = 1; k < j; k++) {
				sum = (sum + ((long) C[i - j - 1][j - 1 - k] * (long) dp(j, k))) % mod;
			}
			table[i][j] = (int) (sum % mod);
		}
		return table[i][j];
	}
}
