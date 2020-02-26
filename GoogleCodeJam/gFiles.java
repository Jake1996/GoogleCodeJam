package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/4284487/dashboard#s=p1
 * 
 * @author jatin
 *
 */
public class gFiles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		long maxvalue, minvalue;
		long start, stop;
		while (tc-- != 0) {
			int n = in.nextInt();
			long files[] = new long[n];
			int percent[] = new int[n];
			boolean found = false;
			for (int i = 0; i < n; i++) {
				percent[i] = in.nextInt();
				files[i] = in.nextLong();
				if (percent[i] == 100)
					found = true;
			}
			if (found) {
				System.out.println("Case #" + (temp - tc) + ": " + files[n - 1]);
				continue;
			}
			maxvalue = Long.MAX_VALUE;
			minvalue = -1;
			for (int i = 0; i < n; i++) {
				if (percent[i] != 0) {
					stop = (long) Math.floor((double) (files[i] * 100) / percent[i]);
					start = (long) Math.floor((double) (files[i] * 100) / (percent[i] + 1)) + 1;
				} else {
					stop = Long.MAX_VALUE;
					start = (long) Math.floor((double) (files[i] * 100) / (percent[i] + 1)) + 1;
				}
				if (maxvalue > stop)
					maxvalue = stop;
				if (minvalue < start)
					minvalue = start;
				if (minvalue > maxvalue)
					minvalue = maxvalue;
			}
			if (maxvalue == minvalue)
				System.out.println("Case #" + (temp - tc) + ": " + maxvalue);
			else
				System.out.println("Case #" + (temp - tc) + ": -1");
		}
		in.close();
	}

}
