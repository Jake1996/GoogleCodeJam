package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cj20171b1 {
    public static final int mod = 1000000007;
    public static long mod2arr[] = new long[10001];

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int tc = in.nextInt();
        int temp = tc;
        mod2arr[0] = 1;
        mod2arr[1] = 2;
        for (int i = 2; i < 10000; i++) {
            mod2arr[i] = (mod2arr[i - 1] * 2) % mod;
        }
        while (tc-- != 0) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            long sum = 0;
            sum -= arr[0] * (mod2arr[n - 1] - 1);
            for (int i = 1; i < n - 1; i++) {
                sum = (sum + arr[i] * (mod2arr[i] - 1)) % mod;
                sum = (sum - arr[i] * (mod2arr[n - i - 1] - 1)) % mod;
            }
            sum += arr[n - 1] * (mod2arr[n - 1] - 1);
            System.out.println("Case #" + (temp - tc) + ": " + sum);
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
