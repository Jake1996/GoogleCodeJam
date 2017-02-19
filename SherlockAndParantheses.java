import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * https://code.google.com/codejam/contest/6304486/dashboard#s=p2
 * @author jake
 *
 */
public class SherlockAndParantheses {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int l = in.nextInt();
			int r = in.nextInt();
			long k = Math.min(l, r);
			k = k*(k+1);
			k/=2;
			System.out.println("Case #"+(temp-tc)+": "+k);
		}
		in.close();
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

