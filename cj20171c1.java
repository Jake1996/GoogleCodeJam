package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class cj20171c1 {

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int tc = in.nextInt();
		int temp = tc;
		while (tc-- != 0) {
			int n, k;
			n = in.nextInt();
			k = in.nextInt();
			ArrayList<node> arrr = new ArrayList<>();
			ArrayList<node> arrh = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				int rad, hie;
				rad = in.nextInt();
				hie = in.nextInt();
				node t = new node(rad, hie);
				arrr.add(t);
				arrh.add(t);
			}
			arrr.sort(new Comparator<node>() {

				@Override
				public int compare(node o1, node o2) {
					return (int) (o2.r - o1.r);
				}
			});
			arrh.sort(new Comparator<node>() {

				@Override
				public int compare(node o1, node o2) {
					if (o2.h * o2.r == o1.h * o1.r)
						return 0;
					if (o2.h * o2.r > o1.h * o1.r)
						return 1;
					else
						return -1;
				}
			});
			double max = Double.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				node t = arrr.get(i);
				t.flag = true;
				long rh = t.r * t.h;
				int l = 1;
				for (int j = 0; j < n && l < k; j++) {
					if (arrh.get(j).flag == false && arrh.get(j).r <= t.r) {
						l++;
						rh += arrh.get(j).h * arrh.get(j).r;
					}
				}
				t.flag = false;
				if (l == k)
					max = Math.max(max, Math.PI * (t.r * t.r + 2 * rh));
			}
			System.out.format("Case #" + (temp - tc) + ": %.9f\n", max);
		}
		in.close();
	}

	static class node {
		long r, h;
		boolean flag;

		public node(int rad, int hie) {
			r = rad;
			h = hie;
			flag = false;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
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
