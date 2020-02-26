package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p1
 * 
 * @author jake
 *
 */
public class TidyNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			char no[] = in.next().toCharArray();
			for (int i = no.length - 1; i > 0; i--) {
				if (no[i] < no[i - 1]) {
					no[i - 1]--;
					for (int j = i; j < no.length; j++)
						no[j] = '9';
				}
			}
			long k = Long.parseLong(new String(no));
			System.out.println("Case #" + (temp - tc) + ": " + k);
		}
		in.close();
	}
}
