import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p2&a=2
 * @author jatin
 *
 */
public class Numbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		final int A[][] = {{3,5},{1,3}};
		while(tc--!=0) {
			int n = in.nextInt();
			int result[][] = fastExponential(A, n);
			int op = (2*result[0][0]+999)%1000;
			String t = Integer.toString(op);
			while (t.length()!=3) {
				t="0"+t;
			}
			System.out.println("Case #"+(temp-tc)+": "+t);
		}
		in.close();

	}
	
	public static int[][] matrixMultiplication(int a[][],int b[][]) {
		int result[][] = new int[2][2];
		result[0][0] = (a[0][0]*b[0][0] +a[0][1]*b[1][0])%1000;
		result[0][1] = (a[0][0]*b[0][1] +a[0][1]*b[1][1])%1000;
		result[1][0] = (a[1][0]*b[0][0] +a[1][1]*b[1][0])%1000;
		result[1][1] = (a[1][0]*b[0][1] +a[1][1]*b[1][1])%1000;
		return result;
	}
	public static int[][] fastExponential(int mat[][],int n) {
		if(n==1)
			return mat;
		if(n%2==0) {
			int temp[][] = matrixMultiplication(mat, mat);
			return fastExponential(temp, n/2);
		}
		else {
			return matrixMultiplication(mat, fastExponential(mat, n-1));
		}
	}

}
