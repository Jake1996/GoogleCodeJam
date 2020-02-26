package GoogleCodeJam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/189252/dashboard#s=p2
 * 
 * @author jake
 *
 */
public class BribeThePrisoners {
	public static int arr[] = new int[101];
	public static int prisoners[][] = new int[10001][10001];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		int P, Q;
		while (tc-- != 0) {
			P = in.nextInt();
			Q = in.nextInt();
			for (int i = 0; i < Q; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr, 0, Q - 1);
			for (int i = 1; i <= P; i++)
				for (int j = 1; j <= P; j++)
					prisoners[i][j] = -1;
			System.out.println("Case #" + (temp - tc) + ": " + ans(1, P, Q, P));
		}
		in.close();
	}

	public static int ans(int start, int end, int max, int P) {
		if (start > P || end > P)
			return 0;
		if (prisoners[start][end] == -1) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < max; i++) {
				if (arr[i] > end)
					break;
				if (arr[i] >= start && arr[i] <= end)
					min = Math.min(min, end - start + ans(start, arr[i] - 1, max, P) + ans(arr[i] + 1, end, max, P));
			}
			if (min == Integer.MAX_VALUE)
				prisoners[start][end] = 0;
			else
				prisoners[start][end] = min;
		}
		return prisoners[start][end];
	}

}
