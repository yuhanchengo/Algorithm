import java.util.ArrayList;
import java.util.Scanner;

public class treeLevel {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int numToTest = scan.nextInt();
		for (int iter = 0; iter < numToTest; iter++) {
			// System.out.println("here");
			int casenum = 0;
			String inline;
			ArrayList<String> al = new ArrayList<String>();
			while (!(inline = scan.next()).equals("()")) {
				al.add(inline);
			}
			int msize = al.size();
			int[][] m = new int[msize + 1][msize + 1];
			for (int i = 0; i < msize + 1; i++) {
				for (int j = 0; j < msize + 1; j++) {
					m[i][j] = -1;
				}
			}
			for (String e : al) {
				int startIndex = e.indexOf(",");
				int endIndex = e.indexOf(")");
				int x = 0, y = 0;
				for (int i = startIndex + 1; i < endIndex; i++) {
					if (e.charAt(i) == 'L') {
						x++;
					} else if (e.charAt(i) == 'R') {
						y++;
					}
				}
				if (m[x][y] == -1) {
					m[x][y] = Integer.parseInt(e.substring(1, startIndex));
				} else if (m[x][y] != -1) {
					casenum = 1;
					System.out.println("not complete");

					break;
				}
			}
			if (casenum != 1) {
				outerloop: for (int j = 0; j < m.length; j++) {
					boolean flag = false;
					for (int i = 0; i < m.length - j; i++) {
						if (flag == false && m[i][j] == -1) {
							flag = true;
						} else if (flag == true && m[i][j] != -1) {
							casenum = 2;
							System.out.println("not complete");
							break outerloop;
						}
					}
				}
			}
			if (casenum != 1 && casenum != 2) {
				for (int level = 0; level < m.length; level++) {
					int a = level, b = 0;
					while (b != level) {
						if (m[a][b] != -1) {
							System.out.print(m[a][b] + " ");
						}
						a--;
						b++;

					}
					if (m[a][b] != -1) {
						System.out.print(m[a][b] + " ");
					}
				}
				System.out.println();
			}

		}

	}

}
