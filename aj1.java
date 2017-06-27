import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class aj1 {
	 
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		double x,y,w;
		double xa,ya,wa;
		ArrayList<node> arr = new ArrayList<>();
		while(tc--!=0) {
			xa=0;ya=0;wa=0;
			int n = in.nextInt();
			arr.clear();
			for(int i=0;i<n;i++) {
				x = in.nextDouble();
				y = in.nextDouble();
				w = in.nextDouble();
				xa+=x*w;
				ya+=y*w;
				wa+=w;
				arr.add(new node(x, y, w));
			}
			xa/=wa;ya/=wa;
			double sum=0;
			for(int i=0;i<n;i++) {
//				System.out.println(sum);
				sum+=Math.max(Math.abs(xa-arr.get(i).x),Math.abs(ya-arr.get(i).y))*arr.get(i).w;
				
			}
			System.out.println("Case #"+(temp-tc)+": "+sum);
		}
		in.close();
	}
	static class node {
		double x,y,w;
		public node(double x,double y,double w) {
			this.x = x;
			this.y = y;
			this.w =w;
		}
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
