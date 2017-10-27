package algHW;

import java.util.Scanner;

public class bubble {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numberOfTests = scan.nextInt();
		for(int i = 0;i <numberOfTests; i++){
			int length = scan.nextInt();
			int[] arr = new int[length];
			int swap =0;
			for(int n=0; n<length; n++){
				arr[n] = scan.nextInt();
			}
			for(int j = 0; j<length; j++){
				Boolean change = false;
				for(int k =0; k<length-j-1; k++){
					if(arr[k]>arr[k+1]){
						int temp = arr[k];
						arr[k] = arr[k+1];
						arr[k+1] = temp;
						swap++;
						change = true;
					}
				}
				if(change == false)
					break;
			}
			System.out.println("Optimal swapping takes "+ swap + " swaps.");
		}
		
	}

}
