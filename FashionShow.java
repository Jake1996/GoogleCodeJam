package GoogleCodeJam;

import java.util.Scanner;

public class FashionShow {
	public static char arr[][][] = new char[102][102][2];
	public static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		int dest[] = new int[2];
		int dest2[] = new int[2];

		while (tc-- != 0) {
			n = in.nextInt();
			int m = in.nextInt();
			for (int i = 0; i <= n + 1; i++) {
				for (int j = 0; j <= n + 1; j++) {
					arr[i][j][0] = arr[i][j][1] = 0;
				}
			}
			for (int i = 0; i < m; i++) {
				int r, c;
				char ch;
				ch = in.next().charAt(0);
				r = in.nextInt();
				c = in.nextInt();
				arr[r][c][0] = arr[r][c][1] = ch;
				if (ch == '+') {
					right(r, c, dest);
					arr[dest[0]][dest[1]][1]++;
					left(r, c, dest);
					arr[dest[0]][dest[1]][1]++;
				} else if (ch == 'x') {
					arr[r][0][0]++;
					arr[0][c][0]++;
				} else if (ch == 'o') {
					right(r, c, dest);
					arr[dest[0]][dest[1]][1]++;
					left(r, c, dest);
					arr[dest[0]][dest[1]][1]++;
					arr[r][0][0]++;
					arr[0][c][0]++;
				}
			}
			// 0 for up down
			// 1 for cross
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j][1] == 0) {
						right(i, j, dest);
						left(i, j, dest2);
						// System.out.println("1 "+dest[0]+" "+dest[1]);
						// System.out.println("2 "+dest2[0]+" "+dest2[1]);
						if (arr[dest[0]][dest[1]][1] == 0 && arr[dest2[0]][dest2[1]][1] == 0) {
							arr[i][j][1] = '+';
							arr[dest[0]][dest[1]][1]++;
							arr[dest2[0]][dest2[1]][1]++;
						} else if (arr[i][0][0] == 0 && arr[0][j][0] == 0) {
							arr[i][j][1] = 'x';
							arr[i][0][0]++;
							arr[0][j][0]++;
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					right(i, j, dest);
					left(i, j, dest2);
					if ((arr[dest[0]][dest[1]][1] == 0 && arr[dest2[0]][dest2[1]][1] == 0)
							|| (arr[i][0][0] == 0 && arr[0][j][0] == 0)) {
						arr[i][j][1] = 'o';
						arr[dest[0]][dest[1]][1]++;
						arr[dest2[0]][dest2[1]][1]++;
						arr[i][0][0]++;
						arr[0][j][0]++;
					}
				}
			}
			// printar();
			print(temp - tc);
		}
		in.close();
	}

	public static void printar() {
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= n + 1; j++) {
				if (arr[i][j][1] == 0) {
					System.out.print(". ");
				} else
					System.out.print(arr[i][j][1] + " ");
			}
			System.out.println();
		}
	}

	public static void right(int i, int j, int dest[]) {
		if (i >= j) {
			dest[0] = n + 1;
			dest[1] = n - i + j;
		} else {
			dest[0] = 0;
			dest[1] = j - i + 1;
		}
	}

	public static void left(int i, int j, int dest[]) {
		if (i + j <= n) {
			dest[0] = i + j - 1;
			dest[1] = 0;
		} else {
			dest[0] = i + j - n;
			dest[1] = n + 1;
		}
	}

	public static void print(int no) {
		int score = 0;
		int diff = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j][1] == '+')
					score++;
				else if (arr[i][j][1] == 'x')
					score++;
				else if (arr[i][j][1] == 'o')
					score += 2;
				if (arr[i][j][0] != arr[i][j][1])
					diff++;
			}
		}
		System.out.println("Case #" + (no) + ": " + score + " " + diff);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j][0] != arr[i][j][1]) {
					System.out.println(arr[i][j][1] + " " + (i) + " " + (j));
				}
			}
		}
	}
}
