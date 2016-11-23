import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/544101/dashboard#s=p1
 * @author jatin
 *
 */
public class Rotate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int n,k;
			n = in.nextInt();
			k = in.nextInt();
			char mat[][] = new char[n][n];
			String ip ="";
			in.nextLine();
			for(int i =0;i < n;i++) {
				ip = in.nextLine();
				for(int j =0;j < n;j++)
					mat[i][j] = ip.charAt(j);
			}
			mat = rotateAndGravity(mat);
			String result = "";
			switch(check(mat,k)) {
			case 0 : result = "Neither";
				break;
			case 1 : result = "Red";
				break;
			case 2 : result = "Blue";
				break;
			case 3 : result = "Both";
				break;
			}
			System.out.println("Case #"+(temp-tc)+": "+result);
		}
		in.close();

	}
	public static char[][] rotateAndGravity(char mat[][]) {
		int size = mat.length;
		char result[][] = new char[size][size];
		for(int i =0;i <size;i++) {
			String temp = new String(mat[i]);
			temp = temp.replaceAll("[^RB]", "");
			int j;
			int len = temp.length();
			for(j =0;j < size&&j<len;j++) {
				result[size-j-1][size-i-1] = temp.charAt(len-j-1);
			}
			for(;j<size;j++) {
				result[size-j-1][size-i-1] = '.';
			}
		}
		return result;
	}
	public static int check(char mat[][],int k) {
		boolean blueFlag = false;
		boolean redFlag = false;
		int redCount = 0;
		int blueCount = 0;
		int size = mat.length;
		//horizontal
		for(int i =0;i < size;i++) {
			redCount = 0;
			blueCount = 0;
			for(int j = 0;j<size;j++) {
				if(mat[i][j]=='B') {
					blueCount++;
					redCount = 0;
				}
				else if(mat[i][j]=='R') {
					redCount++;
					blueCount = 0;
				}
				else {
					redCount = 0;
					blueCount = 0;
				}
				if(redCount==k)
					redFlag = true;
				if(blueCount==k)
					blueFlag = true;
			}
		}
		redCount = 0;
		blueCount = 0;
		//vertical
		if(!redFlag||!blueFlag) {
			for(int i =0;i < size;i++) {
				redCount = 0;
				blueCount = 0;
				for(int j = 0;j<size;j++) {
					if(mat[j][i]=='B') {
						blueCount++;
						redCount = 0;
					}
					else if(mat[j][i]=='R') {
						redCount++;
						blueCount = 0;
					}
					else {
						redCount = 0;
						blueCount = 0;
					}
					if(redCount==k)
						redFlag = true;
					if(blueCount==k)
						blueFlag = true;
				}
			}
		}
		redCount = 0;
		blueCount = 0;
		//diagonal right
		if(!redFlag||!blueFlag) {
			int i,j,l;
			 for(j =0;j<=size-k;j++) {
				 i =0;
				 l=j;
				redCount = 0;
				blueCount = 0;
				 for(;i<size&&l<size;i++,l++) {
						if(mat[i][l]=='B') {
							blueCount++;
							redCount = 0;
						}
						else if(mat[i][l]=='R') {
							redCount++;
							blueCount = 0;
						}
						else {
							redCount = 0;
							blueCount = 0;
						}
						if(redCount==k)
							redFlag = true;
						if(blueCount==k)
							blueFlag = true;
				 }
			 }
			redCount = 0;
			blueCount = 0;
			for(i=1;i<=size-k;i++) {
				j=0;l=i;
				redCount = 0;
				blueCount = 0;
				 for(;l<size&&j<size;j++,l++) {
						if(mat[l][j]=='B') {
							blueCount++;
							redCount = 0;
						}
						else if(mat[l][j]=='R') {
							redCount++;
							blueCount = 0;
						}
						else {
							redCount = 0;
							blueCount = 0;
						}
						if(redCount==k)
							redFlag = true;
						if(blueCount==k)
							blueFlag = true;
				 }
			}
		}
		//diagonal left
		if(!redFlag||!blueFlag) {
			int i,j,l;
			for(j=size-1;j>=k-1;j--) {
				i=0;l=j;
				redCount = 0;
				blueCount = 0;
				for(;l>=0&&i<size;i++,l--) {
					if(mat[i][l]=='B') {
						blueCount++;
						redCount = 0;
					}
					else if(mat[i][l]=='R') {
						redCount++;
						blueCount = 0;
					}
					else {
						redCount = 0;
						blueCount = 0;
					}
					if(redCount==k)
						redFlag = true;
					if(blueCount==k)
						blueFlag = true;
				}
			}
			redCount = 0;
			blueCount = 0;
			for(i=1;i<=size-k;i++) {
				j=size-1;l=i;
				redCount = 0;
				blueCount = 0;
				 for(;l<size&&j>=0;j--,l++) {
						if(mat[l][j]=='B') {
							blueCount++;
							redCount = 0;
						}
						else if(mat[l][j]=='R') {
							redCount++;
							blueCount = 0;
						}
						else {
							redCount = 0;
							blueCount = 0;
						}
						if(redCount==k)
							redFlag = true;
						if(blueCount==k)
							blueFlag = true;
				 }
			}
		}
		if(blueFlag&&redFlag)
			return 3;
		else if(redFlag)
			return 1;
		else if(blueFlag)
			return 2;
		else
			return 0;
	}
}
