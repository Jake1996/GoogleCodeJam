import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cj20171c3 {
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int n,k;
			double u;
			n = in.nextInt();
			double arr[] = new double[n];
			k = in.nextInt();
			u = in.nextDouble();
			for(int i=0;i<n;i++) {
				arr[i] = in.nextDouble();
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			for(int i=0;u>0&&i<n;i++) {
				int j=i;
				for(;j<n&&arr[i]==arr[j];j++) {

				}
				int split=j;
				if(j==n) {
					double eq = u/n;
					for(int l=0;l<n;l++) {
						arr[l] += eq;
					}
					u=0;
				}
				else {
					double diff = arr[j]-arr[i];
					if(u>split*diff) {
						u-=split*diff;
						for(int l=0;l<=j;l++) {
							arr[l] = arr[j];
						}
					}
					else {
						double eq = u/split;
						for(int l=0;l<=j;l++) {
							arr[l] += eq;
						}
						u=0;
					}
				}
			}
			double answer = 1;
			for(int i=0;i<n;i++) {
				answer*= arr[i];
			}
			//System.out.println(Arrays.toString(arr));
			System.out.format("Case #"+(temp-tc)+": %.7f\n",answer);
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
