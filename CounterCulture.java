import java.util.Scanner;

public class CounterCulture {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			long n = in.nextLong();
			long count = 0;
			String ref;
			while(n!=1) {
				//System.out.println(n);
				if((int)Math.log10(n)==4) {
					long a = n;
					a-=a%10;
					a%=Math.pow(10,(int)Math.log10(a));
					if(a<reverse(a)*10) {
						
					}
					else {
						
					}
				}
				if(n<20) {
					count+=n-1;
					n=1;
				}
				else if((int)(n/Math.pow(10,(int)Math.log10(n)))==1) {
					count+=n%Math.pow(10,(int)Math.log10(n))+1;
					n-=n%Math.pow(10,(int)Math.log10(n))+1;
					count++;
				}
				else {
					int k = (int)n%10;
					k = k==0?10:k;
					k--;
					n-=k;
					count+=k;
					ref = new StringBuffer(n+"").reverse().toString();
					n = Long.parseLong(ref);
					count++;
				}
			}
			System.out.println("Case #"+(temp-tc)+": "+(count+1));
		}
		in.close();
	}
	public static long reverse(long a) {
		String ref = new StringBuffer(a+"").reverse().toString();
		a = Long.parseLong(ref);
		return a;
	}
}
