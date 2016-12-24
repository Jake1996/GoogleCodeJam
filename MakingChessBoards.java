import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/619102/dashboard#s=p2
 * @author jake
 *
 */
public class MakingChessBoards {
	public static int grid[][] = new int[512][512];
	public static int dp[][] = new int[512][512];
	public static int ans[] = new int[513];
	public static boolean visited[][] = new boolean[512][512];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		int m,n;
		int cnt;
		String s;
		while(tc--!=0) {
			m = in.nextInt();
			n = in.nextInt();
			for(int i=0;i<m;i++) {
				s = in.next();
				int k;
				for(int j=0;j<n/4;j++) {
					k = Integer.parseInt(s.charAt(j)+"", 16);
					for(int l=0;l<4;l++) {
						int t = 1<<l;
						if((t&k)!=0) 
							grid[i][j*4+4-l-1]=0;
						else
							grid[i][j*4+4-l-1]=1;
					}
				}
			}
			for(int i=0;i<513;i++) ans[i] = 0;
			calculate(m,n);
			cnt=0;
			for(int i=0;i<513;i++) if(ans[i]>0) cnt++;
			System.out.println("Case #"+(temp-tc)+": "+cnt);
			for(int i=512;i>0;i--) if(ans[i]>0) System.out.println(i+" "+ans[i]);
		}
		in.close();

	}
	public static void calculate(int m,int n) {
		for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++)
				dp[i][j] = 1;
		int starti,startj,length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i!=0&&j!=0&&dp[i-1][j-1]>1) {
					dp[i][j] = dp[i-1][j-1]-1;
				}
				boolean outer=true;
				while(outer) {
					starti=dp[i][j]+i;
					startj=dp[i][j]+j;
					if(starti>=m||startj>=n) break;
					length = dp[i][j]+1;
					boolean increment = true;
					for(int k=0;k<length&&increment;k++) {
						if(grid[i+k][startj]==grid[i+k][startj-1])
							increment = false;
						if(grid[starti][j+k]==grid[starti-1][j+k])
							increment = false;
					}
					if(increment==true) {
						dp[i][j]++;
					}
					else {
						outer=false;
					}
				}
			}
		}
		for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++)
				visited[i][j] = false;
		for(int z=Math.min(m, n);z>0;z--) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]&&dp[i][j]>=z&&check(i,j,z)) {
						for(int p=i;p<z+i;p++)
							for(int q=j;q<z+j;q++) {
								visited[p][q]=true;
							}
						ans[z]++;
					}
				}
			}
		}	
	}
	public static boolean check(int i,int j,int len) {
		for(int l=i;l<i+len;l++) {
			for(int m=j;m<j+len;m++) {
				if(visited[l][m]) return false;
			}
		}
		return true;
	}
}
