import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/90101/dashboard#s=p2
 * @author jatin
 *
 */
public class WelcomToCodejam {
	public static int dp[][];
	public static String key = "welcome to code jam";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		in.nextLine();
		while(tc--!=0) {
			String line = in.nextLine();
			dp = new int[line.length()+1][key.length()+1];
			for(int i =1;i<=line.length();i++)
				for(int j = 2;j <=key.length();j++) 
					dp[i][j] = -1;			
			for(int i =1;i<line.length();i++) {
				dp[i][1]+=dp[i-1][1];
				if(line.charAt(i-1)==key.charAt(0)) dp[i][1]++;
				dp[i][1]%=10000;
			}
			String result = Integer.toString(calc(line.length(),key.length(),line)%10000);
			while(result.length()!=4){
				result="0"+result;
			}
			System.out.println("Case #"+(temp-tc)+": "+result);
		}
		in.close();

	}
	public static int calc(int i, int j,String line) {
		if(dp[i][j]==-1) {
			if(line.charAt(i-1)!=key.charAt(j-1)) {
				dp[i][j] = calc(i-1,j,line);
			}
			else {
				dp[i][j] = calc(i-1,j,line)+calc(i-1,j-1,line);
			}
		}
		dp[i][j]%=10000;
		return dp[i][j];
	}

}
