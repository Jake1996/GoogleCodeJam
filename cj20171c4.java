import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cj20171c4 {
	public static int child[] = new int[1441];
	public static int james[] = new int[1441];
	public static int cam[] = new int[1441];
	public static final int C = 0;
	public static final int J = 1;
	public static int dp[][][] = new int[721][1441][2];
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int ac,aj;
			for(int i=0;i<=720;i++)
				for(int j=0;j<=1440;j++)
					for(int k=0;k<2;k++) {
						dp[i][j][k] = -1;
					}
			ac = in.nextInt();
			aj = in.nextInt();
			int ct=0,jt=0;
			for(int i=0;i<ac;i++) {
				int start,end;
				start = in.nextInt();
				end = in.nextInt();
				jt+=end-start;
				for(int j=start;j<end;j++) {
					child[j] = J;
					cam[j] = 1;//busy
				}
			}
			for(int i=0;i<aj;i++) {
				int start,end;
				start = in.nextInt();
				end = in.nextInt();
				ct+=end-start;
				for(int j=start;j<end;j++) {
					child[j] = C;
					james[j] = 1;//busy
				}
			}
			dp[0][1][C]=1; dp[0][1][J]=0;
			int value = func(720,1440,J);
			for(int i=0;i<=720;i++)
				for(int j=0;j<=1440;j++)
					for(int k=0;k<2;k++) {
						dp[i][j][k] = -1;
					}
			dp[0][1][J]=1 ;dp[0][1][C]=0;
			System.out.println(value);
			Math.min(value, func(720,1440,C));//
			
			
			System.out.println("Case #"+(temp-tc)+": " +value);
		}
		in.close();
	}
	public static int func(int jleft,int time,int next) {
		if(jleft<0 || time-jleft<0)return 1488;
		if(dp[jleft][time][next]==-1) {
			
			int cleft = time-jleft;
			if(jleft==0&&cam[time]==1) {
				//return 14888;
				dp[jleft][time][next]=1488;
			}
			else if(cleft==0&&james[time]==1) {
				dp[jleft][time][next]=1488;
				//return 14888;
			}
			if(cam[time]==1)
			{
				if(next==C){
					
					dp[jleft][time][next] =func(jleft-1,time-1,J)+1; 
					//return ;
				}
				else 
					dp[jleft][time][next] = func(jleft-1,time-1,J);
					//return ;
			}
			else if(james[time]==1)
			{
				//System.out.println("Asd");
				if(next==J)
				{
					dp[jleft][time][next] = func(jleft,time-1,C)+1;
					
					
				}
				else 
					dp[jleft][time][next] = func(jleft,time-1,C);
			}
			if(next==C)
			{
				int x = 1499;
				if(jleft>0)x = func(jleft-1,time-1,J)+1;
				if(cleft>0)x = Math.min(x,func(jleft,time-1,C));
				dp[jleft][time][next] = x;
			}
			
			else if(next==J)
			{
				int x = 1499;
				if(jleft>0) x = func(jleft-1,time-1,J);
				if(cleft>0) x = Math.min(x,func(jleft,time-1,C)+1);
				dp[jleft][time][next] = x;
				//return Math.min(func(jleft-1,time-1,J), func(cleft,time-1,C)+1);
			}
			
			
			
		}
		return dp[jleft][time][next];
	}
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        void close() {
        	try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    } 
}
