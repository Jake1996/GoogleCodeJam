package GoogleCodeJam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p1
 * 
 * @author jatin
 *
 */
public class Milkshakes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int noOfMilkshakes, noOfCustomers;
			noOfMilkshakes = in.nextInt();
			noOfCustomers = in.nextInt();
			int customerLikes[][] = new int[noOfCustomers][];
			for (int i = 0; i < noOfCustomers; i++) {
				customerLikes[i] = new int[in.nextInt() * 2];
				for (int j = 0; j < customerLikes[i].length; j++) {
					customerLikes[i][j] = in.nextInt();
					if (j % 2 == 0)
						customerLikes[i][j]--;
				}
			}
			int milkshakeBatches[] = new int[noOfMilkshakes];
			Queue<Integer> unsatisfiedCustomers = new LinkedList<Integer>();
			Queue<Integer> satisfiedCustomers = new LinkedList<Integer>();
			for (int i = 0; i < noOfCustomers; i++) {
				unsatisfiedCustomers.add(i);
			}
			while (!unsatisfiedCustomers.isEmpty()) {
				int customer = unsatisfiedCustomers.remove();
				boolean satisfied = false;
				int malted = -1;
				for (int i = 0; i < customerLikes[customer].length && !satisfied; i += 2) {
					if (milkshakeBatches[customerLikes[customer][i]] == customerLikes[customer][i + 1]) {
						satisfied = true;
					}
					if (customerLikes[customer][i + 1] == 1) {
						malted = customerLikes[customer][i];
					}
				}
				if (satisfied) {
					satisfiedCustomers.add(customer);
				} else if (malted != -1) {
					milkshakeBatches[malted] = 1;
					satisfiedCustomers.add(customer);
					Iterator<Integer> satQueue = satisfiedCustomers.iterator();
					ArrayList<Integer> removeAndAdd = new ArrayList<>();
					while (satQueue.hasNext()) {
						int tempCustomer = satQueue.next();
						boolean tempSatisfied = false;
						for (int k = 0; k < customerLikes[tempCustomer].length; k += 2) {
							if (milkshakeBatches[customerLikes[tempCustomer][k]] == customerLikes[tempCustomer][k + 1])
								tempSatisfied = true;
						}
						if (!tempSatisfied) {
							removeAndAdd.add(tempCustomer);
						}
					}
					satisfiedCustomers.removeAll(removeAndAdd);
					unsatisfiedCustomers.addAll(removeAndAdd);
				} else {
					unsatisfiedCustomers.add(customer);
					break;
				}
			}
			String result = "";
			if (unsatisfiedCustomers.isEmpty()) {
				for (int i = 0; i < milkshakeBatches.length; i++)
					result = result + " " + milkshakeBatches[i];
			} else
				result = " IMPOSSIBLE";

			System.out.println("Case #" + (temp - tc) + ":" + result);
		}
		in.close();

	}

}
