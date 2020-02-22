
package GoogleCodeJam;

import java.util.Scanner;

public class gMatrix {
	public static final int matrix[][] = new int[3000][3000];
	public static final int dp[][] = new int[3000][3000];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int n, k, c, x;
			n = in.nextInt();
			k = in.nextInt();
			c = in.nextInt();
			x = in.nextInt();
			int a[], b[];
			a = new int[n];
			b = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				b[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					matrix[i][j] = (a[i] * (i + 1) + b[j] * (j + 1) + c) % x;
			long sum = 0;
			PreProcess(n, k);
			// for(int i=0;i<n;i++) {
			// for(int j=0;j<n;j++)
			// System.out.print(dp[i][j]);
			// System.out.println();
			// }
			for (int i = 0; i <= n - k; i++)
				for (int j = 0; j <= n - k; j++)
					sum += dp[i + k - 1][j + k - 1];
			System.out.println("Case #" + (temp - tc) + ": " + sum);
		}
		in.close();
	}

	public static int submatrix(int x1, int y1, int x2, int y2) {
		int max = Integer.MIN_VALUE;
		for (int i = x1; i < x2; i++)
			for (int j = y1; j < y2; j++)
				max = Math.max(max, matrix[i][j]);
		return max;
	}

	public static void PreProcess(int n, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = matrix[i][j];
				for (int l = i; l > i - k + 1 && l >= 0; l--) {
					max = Math.max(max, matrix[l][j]);
				}
				for (int l = j; l > j - k + 1 && l >= 0; l--) {
					max = Math.max(max, matrix[i][j]);
				}
				dp[i][j] = max;
			}
		}
	}
}
