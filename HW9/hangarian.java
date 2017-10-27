package hw9;

import java.util.Scanner;

public class hangarian {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testNum = scan.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int line = 0;
			int inputNum = scan.nextInt();
			int[][] minTable = new int[inputNum][inputNum];
			int[][] flagTable = new int[inputNum][inputNum];
			int[][] intactTable = new int[inputNum][inputNum];
			int max = 0; // max num in the table
			for (int j = 0; j < inputNum; j++) {
				for (int k = 0; k < inputNum; k++) {
					intactTable[j][k] = scan.nextInt();
					if (intactTable[j][k] > max) {
						max = intactTable[j][k];
					}
					flagTable[j][k] = intactTable[j][k];
					minTable[j][k] = intactTable[j][k];
				}
			}

			// minimize table
			for (int j = 0; j < inputNum; j++) {
				for (int k = 0; k < inputNum; k++) {
					minTable[j][k] = max - minTable[j][k];
					flagTable[j][k] = max - flagTable[j][k];
				}
			}

			// row reduce
			rowreduce(minTable);
			rowreduce(flagTable);

			line = findMinLine(flagTable);
			if (line != inputNum) {

				colreduce(minTable); // step3
				
				for (int k = 0; k < minTable.length; k++) {
					for (int j = 0; j < minTable.length; j++) {
						flagTable[k][j] = minTable[k][j];
					}
				}
				line = findMinLine(flagTable); // step 4
				printMatrix(flagTable);
				while (line != inputNum) {
					System.out.println("here");
					step5(minTable, flagTable);

					for (int k = 0; k < minTable.length; k++) {
						for (int j = 0; j < minTable.length; j++) {
							flagTable[k][j] = minTable[k][j];
						}
					}
					line = findMinLine(flagTable); // step 4
					
				}
			}
			// step 6
			int[] tag = new int[inputNum];
			int[] ycord = new int[inputNum];
			// by row
			int numOfZero = 0;
			int zeroIndex = -1;
			int numRecord = 0;

			for (int j = 0; j < minTable.length; j++) {
				numOfZero = 0;
				for (int k = 0; k < minTable.length; k++) {
					if (minTable[j][k] == 0) {
						numOfZero++;
						zeroIndex = k;
					}
				}
				if (numOfZero == 1) {
					ycord[j] = zeroIndex;
					if (tag[j] != -1) {
						tag[j] = -1;
					}
					numRecord++;
				}
			}
			numOfZero = 0;
			zeroIndex = -1;
			if (numRecord != inputNum) {
				for (int j = 0; j < minTable.length; j++) {
					numOfZero = 0;
					for (int k = 0; k < minTable.length; k++) {
						if (minTable[k][j] == 0) {
							numOfZero++;
							zeroIndex = k;
						}
					}
					if (numOfZero == 1) {
						ycord[zeroIndex] = j;
						if (tag[zeroIndex] != -1) {
							tag[zeroIndex] = -1;
						}
						numRecord++;
					}
				}
			}

			int totalPoints = 0;
			for (int j = 0; j < ycord.length; j++) {
				totalPoints += intactTable[j][ycord[j]];
			}
			System.out.println(totalPoints);

		}
	}

	public static int findMinLine(int[][] flagmap) {
		int linenum = 0;
		int[] x = new int[flagmap.length];
		int[] y = new int[flagmap.length];

		for (int i = 0; i < flagmap.length; i++) {
			for (int j = 0; j < flagmap.length; j++) {
				if (flagmap[i][j] == 0) {
					x[i] += 1;
					y[j] += 1;
				}
			}
		}
		while (!xyiszero(x, y)) {
			// get max from x and y array
			int cord = 0; // x:1, y:2
			int max = 0;
			int index = -1;
			for (int i = 0; i < flagmap.length; i++) {
				if (x[i] >= y[i] && x[i] >= max) {
					max = x[i];
					cord = 1;
					index = i;
				} else if (x[i] < y[i] && y[i] >= max) {
					max = y[i];
					cord = 2;
					index = i;
				}
			}
			if (cord == 1) {
				for (int j = 0; j < flagmap.length; j++) {
					if (flagmap[index][j] == 0) {
						y[j] -= 1;
						flagmap[index][j] -= 1;
					} else if (flagmap[index][j] < 0) {
						flagmap[index][j] -= 1;
					} else {
						flagmap[index][j] = -1;
					}
				}
				x[index] = 0;
				linenum++;
			} else if (cord == 2) {
				for (int i = 0; i < flagmap.length; i++) {
					if (flagmap[i][index] == 0) {
						x[i] -= 1;
						flagmap[i][index] -= 1;
					} else if (flagmap[i][index] < 0) {
						flagmap[i][index] -= 1;
					} else {
						flagmap[i][index] = -1;
					}
				}
				y[index] = 0;
				linenum++;
			}
		}

		return linenum;

	}

	public static boolean xyiszero(int[] x, int[] y) {
		boolean zero = true;
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0 || y[i] != 0) {
				zero = false;
				break;
			}
		}
		return zero;
	}

	public static void rowreduce(int[][] minmap) {
		for (int j = 0; j < minmap.length; j++) {
			int min = 10000;
			for (int k = 0; k < minmap.length; k++) {
				if (minmap[j][k] < min) {
					min = minmap[j][k];
					// System.out.println(min);
				}
			}
			for (int k = 0; k < minmap.length; k++) {
				minmap[j][k] = minmap[j][k] - min;
			}

		}
	}

	public static void colreduce(int[][] minmap) {
		for (int j = 0; j < minmap.length; j++) {
			int min = 10000;
			for (int i = 0; i < minmap.length; i++) {
				if (minmap[i][j] < min) {
					min = minmap[i][j];
				}
			}
			for (int i = 0; i < minmap.length; i++) {
				minmap[i][j] = minmap[i][j] - min;
			}
		}
	}

	public static void step5(int[][] minmap, int[][] flagmap) {
		int min = 100000;
		for (int i = 0; i < flagmap.length; i++) {
			for (int j = 0; j < flagmap.length; j++) {
				if (flagmap[i][j] > 0 && flagmap[i][j] < min) {
					min = flagmap[i][j];
				}
			}
		}
		for (int i = 0; i < flagmap.length; i++) {
			for (int j = 0; j < flagmap.length; j++) {
				if (flagmap[i][j] > 0) {
					minmap[i][j] -= min;
				} else if (flagmap[i][j] == -2) {
					minmap[i][j] += min;
				}
			}
		}
	}

	public static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
