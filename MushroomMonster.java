import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/4224486/dashboard#s=p0
 * @author jake
 *
 */
public class MushroomMonster {
	public static int arr[]= new int[10001];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int m;
			m=in.nextInt();
			for(int i=0;i<m;i++) {
				arr[i]=in.nextInt();
			}
			int ans1=0,ans2=0;
			int max=0;
			for(int i=1;i<m;i++) {
				if(arr[i-1]-arr[i]>0) ans1+=arr[i-1]-arr[i];
				if((arr[i-1]-arr[i])>max) max = (arr[i-1]-arr[i]);
			}
			if(max!=0) {
				for(int i=0;i<m-1;i++) {
					ans2+=Math.min(arr[i],max);
				}
			}
			System.out.println("Case #"+(temp-tc)+": "+ans1+" "+ans2);
		}
		in.close();

	}

}
