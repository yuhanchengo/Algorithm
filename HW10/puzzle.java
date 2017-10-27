package hw10;

import java.util.Scanner;

public class puzzle {
	public static Scanner scan = new Scanner(System.in);
	public static char[][] goalMatrix = { { '¢°', '¢±', '¢²' }, { '¢·', '¡@', '¢³' }, { '¢¶', '¢µ', '¢´' } };
	public static int xindex = -1, yindex = -1;

	public static void main(String[] args) {
		char[][] input = new char[3][3];
		for (int i = 0; i < input.length; i++) {
			String in = scan.nextLine();
			for (int j = 0; j < input.length; j++) {
				input[i][j] = in.charAt(j);
				if (input[i][j] == (char) 12288) {
					xindex = i;
					yindex = j;
				}
			}
		}
		// System.out.println(xindex + " " + yindex);
		char[][] duplicateArray = new char[input.length][input.length];
		int ev = 0;

		copyArray(input, duplicateArray);
		for (int k = 1; k < 5; k++) {
			
			if (xindex > 0 && k == 1) {
				ev = evalFunction(k, duplicateArray);
				for (int i = 0; i < duplicateArray.length; i++) {
					for (int j = 0; j < duplicateArray.length; j++) {
						System.out.print(duplicateArray[i][j]);
					}
					System.out.println();
				}
				System.out.println(ev);
			} else if (yindex < 2 && k == 2) {
				ev = evalFunction(k, duplicateArray);
				for (int i = 0; i < duplicateArray.length; i++) {
					for (int j = 0; j < duplicateArray.length; j++) {
						System.out.print(duplicateArray[i][j]);
					}
					System.out.println();
				}
				System.out.println(ev);
			} else if (xindex < 2 && k == 3) {
				ev = evalFunction(k, duplicateArray);
				for (int i = 0; i < duplicateArray.length; i++) {
					for (int j = 0; j < duplicateArray.length; j++) {
						System.out.print(duplicateArray[i][j]);
					}
					System.out.println();
				}
				System.out.println(ev);
			} else if (yindex > 0 && k == 4) {
			
				ev = evalFunction(k, duplicateArray);
				for (int i = 0; i < duplicateArray.length; i++) {
					for (int j = 0; j < duplicateArray.length; j++) {
						System.out.print(duplicateArray[i][j]);
					}
					System.out.println();
				}
				System.out.println(ev);
			}
			copyArray(input, duplicateArray);
			
		}

	}

	public static void copyArray(char[][] auth, char[][] copy) {
		for (int i = 0; i < auth.length; i++) {
			for (int j = 0; j < auth.length; j++) {
				copy[i][j] = auth[i][j];
			}
		}
	}

	public static int evalFunction(int direction, char[][] inputMatrix) {
		int eval = 0;
		char temp;
		if (direction == 1) { // up
			temp = inputMatrix[xindex - 1][yindex];
			inputMatrix[xindex - 1][yindex] = inputMatrix[xindex][yindex];
			inputMatrix[xindex][yindex] = temp;

		} else if (direction == 2) { // right
			temp = inputMatrix[xindex][yindex + 1];
			inputMatrix[xindex][yindex + 1] = inputMatrix[xindex][yindex];
			inputMatrix[xindex][yindex] = temp;
		} else if (direction == 3) { // down
			temp = inputMatrix[xindex + 1][yindex];
			inputMatrix[xindex + 1][yindex] = inputMatrix[xindex][yindex];
			inputMatrix[xindex][yindex] = temp;
		} else if (direction == 4) { // left
			temp = inputMatrix[xindex][yindex - 1];
			inputMatrix[xindex][yindex - 1] = inputMatrix[xindex][yindex];
			inputMatrix[xindex][yindex] = temp;
		}
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix.length; j++) {
				if (inputMatrix[i][j] != goalMatrix[i][j]) {
					eval++;
				}
			}
		}
		return eval;
	}

}
