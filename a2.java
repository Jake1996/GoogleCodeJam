import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class a2 {
	public static int dp[][] = new int[2001][2001];
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			String s1 = in.next();
			String s2 = in.next();
			int l1 = s1.length();
			int l2 = s2.length();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(int i=0;i<l1;i++) {
				if(s1.charAt(i)!='*') {
					sb1.append(s1.charAt(i));
				}
				else {
					sb1.append("?");
					sb1.append("?");
					sb1.append("?");
					sb1.append("?");
				}
			}
			for(int i=0;i<l2;i++) {
				if(s2.charAt(i)!='*') {
					sb2.append(s2.charAt(i));
				}
				else {
					sb2.append("?");
					sb2.append("?");
					sb2.append("?");
					sb2.append("?");
				}
			}
			s1 = sb1.toString();
			s2 = sb2.toString();
			for(int i=0;i<=s1.length();i++) 
				for(int j=0;j<=s2.length();j++)
					dp[i][j] = -1;
			int k = matcher(s1, s2, 0,0);
			if(k==1)
				System.out.println("Case #"+(temp-tc)+": TRUE");
			else if(k==0)
				System.out.println("Case #"+(temp-tc)+": FALSE");
		}
		in.close();

	}
	public static int matcher(String s1,String s2,int i,int j) {
		if(dp[i][j]==-1) {
			if(i>=s1.length()&&j>=s2.length()) dp[i][j] = 1;
			if(i>=s1.length()) {
				boolean flag = true;
				for(int k=j;k<s2.length();k++) {
					if(s2.charAt(k)!='?') flag = false;
				}
				if(flag) dp[i][j] = 1;
				else dp[i][j] = 0;
			}
			else if(j>=s2.length()) {
				boolean flag = true;
				for(int k=i;k<s1.length();k++) {
					if(s1.charAt(k)!='?') flag = false;
				}
				if(flag) dp[i][j] = 1;
				else dp[i][j] = 0;
			}
			else if(s1.charAt(i)=='?'&&s2.charAt(j)=='?') {
				int k = matcher(s1, s2, i+1, j+1);
				if(k==0) k = matcher(s1, s2, i, j+1);
				if(k==0) k = matcher(s1, s2, i+1, j);
				dp[i][j] = k;
			}
			else if(s1.charAt(i)=='?') {
				int k =matcher(s1, s2, i+1, j+1);
				if(k==0) k = matcher(s1, s2, i+1, j);;
				dp[i][j] = k;
			}
			else if(s2.charAt(j)=='?') {
				int k = matcher(s1, s2, i+1, j+1);
				if(k==0) matcher(s1, s2, i, j+1);;
				dp[i][j] = k;
			}
			else if(s1.charAt(i)==s2.charAt(j)) {
				dp[i][j] = matcher(s1, s2, i+1, j+1);
			}
			else if(s1.charAt(i)!=s2.charAt(j)) {
				dp[i][j] =  0;
			}
		}
		return dp[i][j];
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
