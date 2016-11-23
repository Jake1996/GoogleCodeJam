import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/4284487/dashboard#s=p0
 * @author jatin
 *
 */
public class gRanks {
	public static final int scoreboard[][] = new int[10000][100];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int P,S[],N,W[],M;
			P = in.nextInt();
			S = new int[P];
			for(int i=0;i<P;i++)
				S[i]= in.nextInt();
			N = in.nextInt();
			W = new int[N];
			String winners[][] = new String[N][P];
			for(int i = 0;i<N;i++) {
				W[i] = in.nextInt();
				for(int j=0;j<P;j++) {
					winners[i][j] = in.next();
				}
			}
			M = in.nextInt();
			HashMap<String , Integer> playerMap = new HashMap<>();
			HashMap<Integer , String> playerMap2 = new HashMap<>();
			int no_of_players = 0;
			for(int i=0;i<N;i++)
				for(int j=0;j<P;j++) {
					String player = winners[i][j];
					int key = -1;
					if(!playerMap.containsKey(player)) {
						key = no_of_players;
						playerMap.put(player,no_of_players);
						playerMap2.put(no_of_players,player);
						no_of_players++;
					}
					else {
						key = playerMap.get(player);
					}
					int value = S[j]*W[i];
					int minIndex = 0;
					for(int k=1;k<M;k++) {
						if(scoreboard[key][k]<scoreboard[key][minIndex])
							minIndex = k;
					}
					if(scoreboard[key][minIndex]<value) {
						scoreboard[key][minIndex] = value;
					}
				}
			for(int i=0;i<no_of_players;i++) {
				for(int j=1;j<M;j++) {
					scoreboard[i][0]+=scoreboard[i][j];
					scoreboard[i][j]=0;
				}
			}
			ArrayList<pl> sc = new ArrayList<>();
			for(int i=0;i<no_of_players;i++) {
				sc.add(new pl(playerMap2.get(i), scoreboard[i][0]));
				scoreboard[i][0] = 0;
			}
			Collections.sort(sc, new Comparator<pl>() {
				@Override
				public int compare(pl p1,pl p2) {
					if(p1.score==p2.score)
						return  p1.name.compareTo(p2.name);
					else
						return p2.score-p1.score;
				}
			});
			System.out.println("Case #"+(temp-tc)+":");
			int rank=1;
			System.out.println(rank+": "+sc.get(0).name);
			for(int i=1;i<no_of_players;i++) {
				if(sc.get(i).score==sc.get(i-1).score) {} else rank = i+1;
				System.out.println(rank+": "+sc.get(i).name);
			}
		}
		in.close();
	}
	public static class pl {
		public pl(String name,int score) {
			this.score = score;
			this.name = name;
		}
		int score;
		String name;
	}
}