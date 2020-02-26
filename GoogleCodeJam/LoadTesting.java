package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/619102/dashboard#s=p1&a=1
 * 
 * @author jake
 *
 */
public class LoadTesting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		int L, P, C;
		while (tc-- != 0) {
			L = in.nextInt();
			P = in.nextInt();
			C = in.nextInt();
			System.out.println("Case #" + (temp - tc) + ": " + (int) Math.ceil((Math.log(pow(L, P, C)) / Math.log(2))));
		}
		in.close();
	}

	public static int pow(int l, int p, int c) {
		int count = 0;
		long num = l;
		while (num < p) {
			num = num * c;
			count++;
		}
		return count;
	}

}
