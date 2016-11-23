import java.util.Scanner;

public class PickingUpChicks {
	public static final int dp[][]= new int[1001][51]; 
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
			for(int i=0;i<T;i++)
				for(int j=0;j<N;j++) {
					dp[i][j] = x[j]+v[j]*i;
				}
			System.out.println("Case #"+(temp-tc)+": "+solve(N,K,B,T));
		}
		System.out.println("done");
		in.close();
	}
	public static int solve(int n,int k,int b,int t) {
		for(int i=0;i<t;i++) {
			for(int j=n-1;j>=0;j--) {
				
			}
		}
		return 0;
	}
	
}
