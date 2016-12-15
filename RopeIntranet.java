import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/619102/dashboard#s=p0
 * @author jake
 *
 */
public class RopeIntranet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		ArrayList<rope> arr = new ArrayList<>();
		while(tc--!=0) {
			int n = in.nextInt();
			arr.clear();
			for(int i=0;i<n;i++)
				arr.add(new rope(in.nextInt(),in.nextInt()));
			arr.sort(new Comparator<rope>() {
				@Override
				public int compare(rope o1, rope o2) {
					return o1.a-o2.a;
				}
			});
			int count=0;
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					if(arr.get(i).b>arr.get(j).b)
						count++;
			System.out.println("Case #"+(temp-tc)+": "+count);
		}
		in.close();

	}
	static class rope {
		int a;
		int b;
		public rope(int x,int y) {
			a = x;
			b = y;
		}
	}

}
