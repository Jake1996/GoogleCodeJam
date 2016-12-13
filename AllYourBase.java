import java.util.HashMap;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/189252/dashboard#s=p0
 * @author jake
 *
 */
public class AllYourBase {
	public static HashMap<Character, Integer> hm = new HashMap<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		String str;
		int count;
		while(tc--!=0) {
			hm.clear();
			str = in.next();
			count = 0;
			for(int i=0;i<str.length();i++) {
				if(!hm.containsKey(str.charAt(i))) {
					if(count==0) {
						hm.put(str.charAt(i), 1);
					}
					else if (count==1) {
						hm.put(str.charAt(i), 0);
					}
					else {
						hm.put(str.charAt(i), count);
					}
					count++;				
				}
			}
			if(count==1) count++;
			System.out.println("Case #"+(temp-tc)+": "+ans(str,count));
		}
		in.close();
	}
	public static long ans(String s,int base) {
		long num = 0;
		int val;
		long mul = 1;
		for(int i=s.length()-1;i>=0;i--) {
			val = hm.get(s.charAt(i));
			num+=mul*val;
			mul*=base;
		}
		return num;
	}

}
