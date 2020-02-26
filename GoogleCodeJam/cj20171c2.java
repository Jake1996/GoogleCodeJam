package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cj20171c2 {
    public static int child[] = new int[1440];
    public static int james[] = new int[1440];
    public static int cam[] = new int[1440];
    public static final int C = 1;
    public static final int J = 2;

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int tc = in.nextInt();
        int temp = tc;
        while (tc-- != 0) {
            int ac, aj;
            ac = in.nextInt();
            aj = in.nextInt();
            int ct = 0, jt = 0;
            for (int i = 0; i < ac; i++) {
                int start, end;
                start = in.nextInt();
                end = in.nextInt();
                jt += end - start;
                for (int j = start; j < end; j++) {
                    child[j - 1] = J;
                    cam[j - 1] = 1;// busy
                }
            }
            for (int i = 0; i < aj; i++) {
                int start, end;
                start = in.nextInt();
                end = in.nextInt();
                ct += end - start;
                for (int j = start; j < end; j++) {
                    child[j - 1] = C;
                    james[j - 1] = 1;// busy
                }
            }
            System.out.println("Case #" + (temp - tc) + ": ");
        }
        in.close();
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
