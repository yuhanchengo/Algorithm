package algHW4;

import java.util.Scanner;

public class lowestScore {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numToTest = scan.nextInt();
		for(int i=0; i<numToTest; i++){
			int totalNum = scan.nextInt();
			int[] Array = new int[totalNum];
			int n = -1;
			int nextClass=-1;
			for(int j=0; j<totalNum; j++){
				Array[j] = scan.nextInt();
				if(n>Array[j]){
					nextClass = j;
				}
				n = Array[j];
			}
			int Aindex = 0;
			int Bindex = nextClass;
			int output = 1;
			while(output<4 && (Aindex<nextClass|| Bindex<totalNum)){
				if(Aindex==nextClass){
					System.out.print("B");
					Bindex++;
					output++;
				}else if(Bindex==totalNum){
					System.out.print("A");
					Aindex++;
					output++;
				}else{
					if(Array[Aindex] < Array[Bindex]){
						System.out.print("A");
						Aindex++;
						output++;
					}else{
						System.out.print("B");
						Bindex++;
						output++;
					}
				}
			}
			System.out.println();
			//System.out.println(nextClass);
		}

	}

}
