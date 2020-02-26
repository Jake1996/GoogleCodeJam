package GoogleCodeJam;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/90101/dashboard#s=p0
 * 
 * @author jatin
 *
 */
public class AlienLanguage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l, d, n;
		l = in.nextInt();
		d = in.nextInt();
		n = in.nextInt();
		String lang[] = new String[d];
		for (int i = 0; i < d; i++)
			lang[i] = in.next();
		int tc = n;
		int temp = tc;
		while (tc-- != 0) {
			String word = in.next();
			String choices[] = split(word, l);
			int count = 0;
			for (int i = 0; i < d; i++) {
				boolean flag = true;
				for (int j = 0; j < l; j++) {
					if (!choices[j].contains(Character.toString(lang[i].charAt(j)))) {
						flag = false;
						break;
					}
				}
				if (flag)
					count++;
			}
			System.out.println("Case #" + (temp - tc) + ": " + count);
		}
		in.close();
	}

	public static String[] split(String word, int l) {
		String set[] = new String[l];
		boolean bracket = false;
		int index = 0;
		for (int i = 0; i < l; i++) {
			if (word.charAt(index) == '(')
				bracket = true;
			if (bracket) {
				int startIndex = index;
				while (word.charAt(index) != ')') {
					index++;
				}
				bracket = false;
				set[i] = word.substring(startIndex + 1, index);
			} else
				set[i] = Character.toString(word.charAt(index));
			index++;
		}
		return set;
	}

}
