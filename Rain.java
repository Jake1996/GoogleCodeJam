
import java.util.Scanner;

public class Rain {
	public static final int mat1[][] = new int[50][50];
	public static final int mat2[][] = new int[50][50];
	public static boolean visited[][] = new boolean[50][50];
	public static boolean pressed[][] = new boolean[50][50];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int m,n;
			m = in.nextInt();
			n = in.nextInt();
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++) {
					mat1[i][j] = in.nextInt();
					mat2[i][j] = mat1[i][j];
					visited[i][j] = false;
					pressed[i][j] = false;
				}
			solve(m,n);
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++)
					System.out.print(mat2[i][j]);
				System.out.println();
			}
			System.out.println("Case #"+(temp-tc)+": "+diff(m,n));
		}
		in.close();

	}
	public static void solve(int m,int n) {
		for(int i=1;i<m;i++) 
			for(int j=1;j<n;j++) {
				if(!visited[i][j]) {
					func(i,j,m,n);
				}
			}
	}
	public static boolean isEdge(int i,int j,int m,int n) {
		if(i==0||j==0||i==m-1||j==n-1) return true;
		return false;
	}
	public static int func(int i,int j,int m,int n) {
		if(isEdge(i, j, m, n))
			return mat2[i][j];
		if(pressed[i][j]) return 2000;
		if(visited[i][j]) return mat2[i][j];
		pressed[i][j] = true;
		int k = mini(i,j,m,n);
		if(k!=-1) {
			mat2[i][j] = Math.max(mat2[i][j],k);
			visited[i][j] = true;
		}
		pressed[i][j] = false;
		if(k==-1)
			return 2000;
		return mat2[i][j];
	}
	public static int diff(int m,int n) {
		int sum = 0;
		for(int i=1;i<m;i++) 
			for(int j=1;j<n;j++)
				sum+=mat2[i][j]-mat1[i][j];
		return sum;
	}
	public static int mini(int i,int j,int m,int n) {
		int min = 2000;
		if(pressed[i-1][j]||pressed[i][j+1]||pressed[i][j-1]||pressed[i+1][j])
			return -1;
//		if(!pressed[i-1][j])
		min = Math.min(min, func(i-1,j,m,n));
//		if(!pressed[i][j+1])
		min = Math.min(min, func(i,j+1,m,n));
//		if(!pressed[i][j-1])
		min = Math.min(min, func(i,j-1,m,n));
//		if(!pressed[i+1][j])
		min = Math.min(min, func(i+1,j,m,n));
//		if(min==2000)
//			return -1;
		return min;
	}

}
