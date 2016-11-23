import java.util.Scanner;

public class NumberGame {
	final static int dp[][] = new int[1000001][1000001];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int A1,A2,B1,B2;
			A1 = in.nextInt();
			A2 = in.nextInt();
			B1 = in.nextInt();
			B2 = in.nextInt();
			int count=0;
			for(int i=0;i<1000001;i++)
				for(int j=0;j<=i;j++)
					dp[i][j] = -1;
			for(int i=A1;i<=A2;i++) 
				for(int j=B1;j<=B2;j++) {
					if(i>j) {
						if(dp[i][j]==-1)
							dp[i][j]=winner(i,j)==true?1:0;
						count+=dp[i][j];
					}
					else {
						if(dp[j][i]==-1)
							dp[j][i]=winner(j,i)==true?1:0;
						count+=dp[j][i];
					}
				}
			System.out.println("Case #"+(temp-tc)+": "+count);
		}
		in.close();
	}
	public static boolean winner(int a,int b) {
		if(b==0) return true;
		if(a>=2*b) return true;
		return !winner(b,a-b);
	}
}
