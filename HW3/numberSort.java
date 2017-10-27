package algHW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class numberSort {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int  numberOfTests = scan.nextInt();
		for(int i =0; i<numberOfTests; i++){
			int length = scan.nextInt();
			int number = scan.nextInt();
			ArrayList<Integer> inputLine = new ArrayList<Integer>();
			ArrayList<String> outputLines = new ArrayList<String>();
			for(int j = 0; j<number; j++){
				int count = 0;
				outputLines.add(j,scan.next());
				for(int k=0; k<length-1; k++){
					for(int l=k+1; l<length; l++){
						if((outputLines.get(j).charAt(k)-outputLines.get(j).charAt(l))>0){
//							System.out.println(outputLines.get(j).charAt(k)+" & "+outputLines.get(j).charAt(l) + " is " + (outputLines.get(j).charAt(k)-outputLines.get(j).charAt(l)));
							count++;
						}
					}
				}
				inputLine.add(j,count);
//				System.out.println("line: " + outputLines.get(j) + " = " + inputLine[j] );
			}
			for(int n =0; n<number; n++){
				System.out.println(outputLines.get(n)+": "+inputLine.get(n));
			}
//			int min = 1000;
//			int numberOfOutput = 0;
//			while(numberOfOutput!=number){
//				int n=0; 
//				int index = -1;
//				while(n < number){
//					if(inputLine.get(n)<min){
//						min = inputLine.get(n);
//						index = n;
//					}
//					n++;
//				}
//				
//			
//			}
			
		}
	}

}
