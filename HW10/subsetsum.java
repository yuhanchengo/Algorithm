package hw10;


import java.util.Arrays;
import java.util.Scanner;


public class subsetsum {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int numToTest = Integer.parseInt(scan.nextLine());
		for(int i=0; i<numToTest; i++){
			String inline = scan.nextLine();
			int c = Integer.parseInt(inline.split(";")[1]);
			inline = inline.split(";")[0];
			String[] temp = inline.split(" ");
			int[] v = new int[temp.length];
			for(int j =0; j<temp.length; j++){
				v[j] = Integer.parseInt(temp[j]);
			}
			Arrays.sort(v);
			int[][] vtable = new int[v.length+1][c+1];
			for(int w =0; w <=c ; w++){
				vtable[0][w] = 0;
			}
			int n = v.length;
			for(int j=1; j<=v.length ; j++){
				for(int w =0; w<=c ;w++){
					if(v[j] <= w){
						vtable[j][w] = max(vtable[j-1][w], v[j] + vtable[j-1][w-v[j]]);
					}else{
						vtable[j][w] = vtable[j-1][w];
					}
				}
			}
			if(vtable[n][c] == c){
				System.out.println("True");
			}else{
				System.out.println("False");
			}
			
		}
	}
	public static int max(int a, int b){
		if(a >=b){
			return a;
		}
		return b;
	}

}
