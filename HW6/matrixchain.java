package HW6;

import java.util.Scanner;

public class matrixchain {

	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int matrixSize = scan.nextInt();
		int[] p = new int[matrixSize+1];
		for(int i =0; i < p.length; i++){
			p[i] = scan.nextInt();
		}
		int[][] m = new int[matrixSize+1][matrixSize+1];
		for(int i =1; i<matrixSize; i++){
			m[i][i] = 0;
		}
		for(int l = 2; l<=matrixSize; l++){
			for(int i =1; i<=matrixSize-l+1; i++){
				int j = i+l-1;
				m[i][j] = 1000000;
				for(int k = i; k<=j-1; k++){
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < m[i][j]){
						m[i][j] = q;
					}
				}
			}
		}
		System.out.println(m[1][matrixSize]);
	}

}
