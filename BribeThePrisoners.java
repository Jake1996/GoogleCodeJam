import java.util.Scanner;

public class BribeThePrisoners {
	public static int arr[] = new int[101];
	public static boolean prisoners[] = new boolean[10001];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		int P,Q;
		while(tc--!=0) {
			P = in.nextInt();
			Q = in.nextInt();
			for(int i=0;i<Q;i++) {
				arr[i] = in.nextInt();
			}
			System.out.println("Case #"+(temp-tc)+": "+ans(Q-1,P));
			for(int i=0;i<=P;i++) prisoners[i] = false;
		}
		in.close();
	}
	public static int ans(int q,int p) {
		int count = 0;
		int i=0;
		int j=q;
		int low=1;
		int high = p;
		while(i<=j) {
			if(arr[i]-low>high-arr[j]) {
				count+=arr[i]-low;
				count+=high-arr[i];
				low=arr[i]+1;
				i++;
			}
			else {
				count+=arr[j]-low;
				count+=high-arr[j];
				high=arr[j]-1;
				j--;
			}
		}
		return count;
	}
	public static int ans(int start,int end,int max) {
		if(arr[(start+end)/2]==-1) return 0;
		if(start<0||start>end) return 0;
		int mid = arr[(start+end)/2];
		arr[(start+end)/2] = -1;
		prisoners[mid] = true;
		int count = 0;
		for(int i=mid-1;i>=1&&!prisoners[i];i--,count++) ;
		for(int i=mid+1;i<=max&&!prisoners[i];i++,count++) ;
		return count+ans(start, (start+end)/2-1, max)+ans((start+end)/2+1, end,max);
	}

}
