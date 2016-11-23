import java.util.Scanner;

public class codejam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			String name[];
			int n = in.nextInt();
			in.nextLine();
			name = new String[n];
			for(int i=0;i<n;i++) {
				name[i] = in.nextLine();
			}
			int index = 0;
			int max = counter(name[0]);
			for(int i=1;i<n;i++) {
				int t = counter(name[i]);
				if(t>max) {
					max = t;
					index = i;
				}
				else if(t==max&&name[index].compareTo(name[i])>0) {
					max = t;
					index = i;
				}
			}
			System.out.println("Case #"+(temp-tc)+": "+name[index]);
		}
		in.close();

	}
	public static int counter(String name) {
		int arr[];
		int count = 0;
		arr = new int[26];
		String original = name.replaceAll(" ", "");
		for(int i=0;i<original.length();i++) {
			if(arr[original.charAt(i)-65]==0) {
				count++;
				arr[original.charAt(i)-65]++;
			}
		}
		return count;
		
	}

}
