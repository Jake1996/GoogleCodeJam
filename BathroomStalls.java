package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p2
 * 
 * @author jake
 *
 */
public class BathroomStalls {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			long n = in.nextLong();
			long k = in.nextLong();
			n -= (k - largestPower(k));
			k = largestPower(k);
			n /= k;
			long l, r;
			n--;
			int add = 0;
			if (n % 2 == 1) {
				add = 1;
			}
			l = r = n >> 1;
			System.out.println("Case #" + (temp - tc) + ": " + (l + add) + " " + r);
		}
		in.close();

	}

	public static long largestPower(long n) {
		int count = 0;
		while (n != 1) {
			n = n >> 1;
			count++;
		}
		return (long) Math.pow(2, count);
		// n = n|(n>>1);
		// n = n|(n>>2);
		// n = n|(n>>4);
		// n = n|(n>>8);
		// return (n+1)>>1;
	}
}
