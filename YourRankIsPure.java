
import java.util.Scanner;

public class YourRankIsPure {
	public static int mod = 100003;
	public static int dp[] = new int[501];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		dp[2]= 1;
		dp[3] = 2;
		int n; 
		while(tc--!=0) {
			n = in.nextInt();
			System.out.println("Case #"+(temp-tc)+": "+ans(n));
		}
		in.close();

	}
	public static int ans(int n) {
		if(dp[n]==0) {
			dp[n]= (ans(n-1)+ans(n-2))%mod;
		}
		return dp[n];
	}

}
