import java.util.ArrayList;
import java.util.Scanner;

public class TheRepeater {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        int temp = tc;
        while (tc-- != 0) {
            int n = in.nextInt();
            ArrayList<ArrayList<node>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(new ArrayList<node>());
                String s = in.next();
                char c = s.charAt(0);
                int v = 1;
                int j = 1;
                while (j <= s.length()) {
                    while (j < s.length() && s.charAt(j) == c) {
                        j++;
                        v++;
                    }
                    arr.get(i).add(new node(c, v));
                    if (j == s.length())
                        break;
                    c = s.charAt(j);
                    v = 1;
                }
            }
            //System.out.println(arr.get(0).size()+" "+arr.get(1).size());
            boolean flag = true;
            int m = arr.get(0).size();
            for (int i = 0; i < n; i++) {
                if (arr.get(i).size() != m) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; flag && i < m; i++) {
                    char c = arr.get(0).get(i).ch;
                    for (int j = 0; j < n; j++) {
                        if (arr.get(j).get(i).ch != c) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println("Case #" + (temp - tc) + ": Fegla Won");
                continue;
            }
            int total = 0;
            for (int i = 0; i < m; i++) {
                int sum = Integer.MAX_VALUE;
                for (int k = 1; k <= 100; k++) {
                    int lsum = 0;
                    for (int j = 0; j < n; j++) {
                        lsum += Math.abs(arr.get(j).get(i).val - k);
                    }
                    sum=Math.min(sum, lsum);
                }
                total+=sum;

            }
            System.out.println("Case #" + (temp - tc) + ": " + total);
        }
        in.close();
    }

    static class node {
        char ch;
        int val;

        public node(char c, int v) {
            ch = c;
            val = v;
        }
    }
}