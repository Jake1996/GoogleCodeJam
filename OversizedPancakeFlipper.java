import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p0
 * @author jake
 *
 */
public class OversizedPancakeFlipper {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			char arr[] = in.next().toCharArray();
			int s = in.nextInt();
			int count=0;
			for(int i=0;i<=arr.length-s;i++) {
				if(arr[i]=='-') {
					count++;
					for(int j=i;j<i+s;j++) {
						arr[j] = arr[j]=='-'?'+':'-';
					}
				}
			}
			boolean check = true;
			for(int i=arr.length-s;i<arr.length;i++) {
				if(arr[i]=='-') {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println("Case #"+(temp-tc)+": "+count);
			}
			else {
				System.out.println("Case #"+(temp-tc)+": IMPOSSIBLE");				
			}
		}
		in.close();

	}

}
