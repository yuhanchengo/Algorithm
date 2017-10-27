package algHW4;

import java.util.Scanner;

public class maxSubsequence {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numToTest = scan.nextInt();
		int[] Array = new int[10];
		for(int i =0; i<numToTest; i++){
			for(int j=0; j<10;j++){
				Array[j] = scan.nextInt();
			}
			
			System.out.println(MaxSequence(Array.clone(), 0, (Array.length)-1));
			
		}
	}
	public static int MaxSequence(int[] inputArray, int l, int r){
		if(l==r)
			return inputArray[l];
		int m = (r+l)/2;
		//System.out.println(m);
		int msl = MaxSequence(inputArray.clone(),l,m);
		int msr = MaxSequence(inputArray.clone(),m+1,r);
		
		int mbl = -100000000;
		int tl =0;
		for(int i=m; i>=l; i--){
			tl = tl + inputArray[i];
			if(tl>mbl){
				mbl = tl;
			}
		}
		int mbr = -100000000;
		int tr = 0;
		for(int j=m+1; j<=r; j++){
			tr = tr + inputArray[j];
			if(tr>mbr){
				mbr = tr;
			}
		}
		
		return Max(msl,msr,mbl+mbr);
		
	}
	public static int Max(int a, int b, int c){
		int max = 0;
		if(a>max){
			max = a;
		}
		if(b>max){
			max = b;
		}
		if(c>max){
			max = c;
		}
		return max;
	}

}
