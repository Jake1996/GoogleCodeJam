
import java.util.Scanner;

public class gGames {
	public static final int arr[] = new int[32];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int N,M;
			N = in.nextInt();
			M = in.nextInt();
			elf list[] = new elf[M];
			for(int i=0;i<M;i++) {
				int e,k,b;
				e = in.nextInt();
				k = in.nextInt();
				b = in.nextInt();
				list[i] = new elf(e,k,b);
				list[i].accept(in);
			}
			for(int i=0;i<32;i++) arr[i] = 0;
			for(int i=N;i<2*N;i++)
				arr[i] =(i%N)+1;
			
			System.out.println("Case #"+(temp-tc)+": ");
		}
		in.close();
	}
	public static class elf {
		int k;
		int id;
		int friend[];
		public elf(int e,int k,int b) {
			friend = new int[b];
			id = e;
			this.k = k;
		}
		public void accept(Scanner in) {
			for(int i=0;i<friend.length;i++)
				friend[i] = in.nextInt();
		}
	}
}
