package HW7;

import java.util.Scanner;

public class KnapSack {

	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int NumToTest = scan.nextInt();
		for(int i =0; i<NumToTest; i++){
			int W = scan.nextInt(); // 最大負載重量
			int[] w = new int[6];
			for(int j =1; j<6; j++){
				w[j] = scan.nextInt();
			}

			int[] v = new int[6];
			for(int k=1; k<6; k++){
				v[k] = scan.nextInt();
			}

			System.out.println(getMax(v,w,6,W));
		}

	}
	public static int getMax(int[] v ,int[] w, int n, int W){
		int V[][] = new int[6][W+1];
		for(int c=0; c<=W; c++){
			V[0][c] = 0;
		}
		for(int i =1; i<n; i++){
			for(int weight=0; weight<=W; weight++){
				if(w[i]<=weight){
					V[i][weight] = max(V[i-1][weight], v[i]+V[i-1][weight-w[i]]);
				}else{
					V[i][weight] = V[i-1][weight];
				}
			}
		}
		return V[5][W];
	}
	public static int max(int a,int b){
		if(a>b){
			return a;
		}
		return b;
	}

}
