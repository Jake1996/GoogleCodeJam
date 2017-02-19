import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * https://code.google.com/codejam/contest/6304486/dashboard#s=p0
 * @author jake
 *
 */
public class CountryLeader {
	public static void main(String[] args) {
		System.out.println("abc".compareTo("bcd"));
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int n = in.nextInt();
			String arr[] = new String[n];
			for(int i=0;i<n;i++) {arr[i] = in.nextLine();}
			int index=0;
			int count=0;
			for(int i=0;i<n;i++) {
				int dif=0;
				HashSet<Character> hs = new HashSet<>();
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].charAt(j)!=' '&&!hs.contains(arr[i].charAt(j))) {
						dif++;
						hs.add(arr[i].charAt(j));
					}
				}
				if(dif>count) {index=i;count=dif;}
				else if(dif==count) {
					if(arr[i].compareTo(arr[index])<0) {
						index=i;count=dif;
					}
				}
			}
			System.out.println("Case #"+(temp-tc)+": "+arr[index]);
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

