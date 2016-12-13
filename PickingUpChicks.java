import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/635101/dashboard#s=p1
 * @author jake
 *
 */
public class PickingUpChicks {
	public static final int dp[]= new int[51]; 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int N,K,B,T,x[],v[];
			N = in.nextInt();
			K = in.nextInt();
			B = in.nextInt();
			T = in.nextInt();
			x = new int[N];
			v = new int[N];
			for(int i=0;i<N;i++)
				x[i] = in.nextInt();
			for(int i=0;i<N;i++)
				v[i] = in.nextInt();
			for(int j=0;j<N;j++) {
				dp[j] = x[j]+v[j]*T;
			}
			int count = 0;
			for(int i=0;i<N;i++) {
				if(dp[i]>=B) count++;
			}
			if(count<K)
				System.out.println("Case #"+(temp-tc)+": "+"IMPOSSIBLE");
			else
				System.out.println("Case #"+(temp-tc)+": "+solve(N,K,B));
		}
		in.close();
	}
	public static int solve(int n,int k,int b) {
		int count = 0;
		int temp;
		for(int i=n-1;i>=n-k;i--) {
			if(dp[i]<b) {
				int j=0;
				for(j=i-1;j>=0;j--) {
					if(dp[j]>=b) break;
				}
				temp=dp[j];
				while(j!=i) {
					dp[j]=dp[j+1];
					j++;
					count++;
				}
				dp[i]=temp;
			}
		}
		return count;
	}
	
}
