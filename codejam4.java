import java.util.Arrays;
import java.util.Scanner;

public class codejam4 {

	public static int answerArray[][];
	public static int noOfCoinsToUpgrade[][];
	public static int attackPowerOfLevel[][];
	public static int noOfCoins,noOfCards;
	public static int maxLevel[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int currentLevel[];
			noOfCoins = in.nextInt();
			noOfCards = in.nextInt();
			maxLevel = new int[noOfCards];
			currentLevel = new int[noOfCards];
			attackPowerOfLevel = new int[noOfCards][];
			noOfCoinsToUpgrade = new int[noOfCards][];
			for(int i = 0;i<noOfCards;i++) {
				maxLevel[i] = in.nextInt();
				currentLevel[i] = in.nextInt();
				attackPowerOfLevel[i] = new int[maxLevel[i]+1];
				noOfCoinsToUpgrade[i] = new int[maxLevel[i]];
				for(int j = 1;j<=maxLevel[i];j++)
					attackPowerOfLevel[i][j] = in.nextInt();
				for(int j = 1;j<maxLevel[i];j++)
					noOfCoinsToUpgrade[i][j] = in.nextInt();
			}
			answerArray = new int[noOfCards+1][noOfCoins+1];
			for(int i = 1;i<=noOfCards;i++) {
				for(int j = 1;j<=noOfCoins;j++)
					answerArray[i][j]= -1;
			}
			System.out.println("Case #"+(temp-tc)+": "+(value(currentLevel)+knapsack(noOfCards-1, noOfCoins,currentLevel)));
		}
		in.close();
	}
	public static int knapsack(int card,int coins,int currentLevel[]) {
		if(answerArray[card][coins]!=-1) {
			return answerArray[card][coins];
		}
		if(maxLevel[card]==currentLevel[card]||coins<noOfCoinsToUpgrade[card][currentLevel[card]])
			answerArray[card][coins] = knapsack(card-1, coins,currentLevel);
		else {
			int temp1,temp2;
			temp1 = knapsack(card-1, coins,currentLevel);
			int tempo[] = Arrays.copyOf(currentLevel, currentLevel.length);
			int tempo2[] = Arrays.copyOf(currentLevel, currentLevel.length);
			tempo[card]++;
			tempo2[card]++;
			temp2 = attackPowerOfLevel[card][currentLevel[card]+1]-attackPowerOfLevel[card][currentLevel[card]]+
					knapsack(card-1, coins-noOfCoinsToUpgrade[card][currentLevel[card]],tempo);
			int temp3 = attackPowerOfLevel[card][currentLevel[card]+1]-attackPowerOfLevel[card][currentLevel[card]]+
					knapsack(card, coins-noOfCoinsToUpgrade[card][currentLevel[card]],tempo2);
//			int t = temp2>temp1?value(tempo):value(currentLevel);
			
			answerArray[card][coins] = Math.max(temp1, temp2);
			answerArray[card][coins] = Math.max(answerArray[card][coins], temp3);
			//answerArray[card][coins]+=t;
			
		}
		return answerArray[card][coins];
	}
	public static int value(int currentLevel[]) {
		int sum = 0;
		for(int i =0;i<noOfCards;i++) {
			sum+=attackPowerOfLevel[i][currentLevel[i]];
		}
		return sum;
	}
}
