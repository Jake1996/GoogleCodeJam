package GoogleCodeJam;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p0
 * 
 * @author jatin
 *
 */
public class MinimumScalarProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int n = in.nextInt();
			int arr1[], arr2[];
			arr1 = new int[n];
			arr2 = new int[n];
			for (int i = 0; i < n; i++)
				arr1[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				arr2[i] = in.nextInt();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			BigInteger product = BigInteger.valueOf(0);
			for (int i = 0; i < n; i++)
				product = product.add(BigInteger.valueOf(arr1[i]).multiply(BigInteger.valueOf(arr2[n - i - 1])));
			System.out.println("Case #" + (temp - tc) + ": " + product);
		}
		in.close();

	}

}
