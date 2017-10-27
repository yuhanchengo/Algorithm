package algHW4;


import java.util.Scanner;

public class Building {
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numToTest = scan.nextInt();
		for (int i = 0; i < numToTest; i++) {
			int inputNum = scan.nextInt();
			int[] inputArray = new int[inputNum];
			int negNums = 0;
			for (int j = 0; j < inputNum; j++) {
				inputArray[j] = scan.nextInt();
				if (inputArray[j] < 0)
					negNums++;
			}
			mergeSort merge = new mergeSort(inputArray);
//			 for(int ele: inputArray){
//			 System.out.print(ele + " ");
//			 }
//			 System.out.println();
			int leftrb = 0;
			int rightrb = negNums;
			int floor = 0;
			int last = 0;
			Boolean first = true;
//			int counter =1;
			while (true) {
				if (first) {
					if (Math.abs(inputArray[rightrb]) <  Math.abs(inputArray[leftrb])) {
						floor++;
						rightrb++;
						first = false;
						last = 1;
					} else {
						floor++;
						leftrb++;
						first = false;
						last = -1;
					}
				}else{
					if(last == -1){ 
						if(rightrb == inputArray.length)
							break;
						if(Math.abs(inputArray[rightrb])> Math.abs(inputArray[leftrb-1])){
							floor++;
							rightrb++;
							last = 1;
						}else
							rightrb++;
					}else if(last == 1){
						if(leftrb == negNums)
							break;
						if(Math.abs(inputArray[leftrb])> Math.abs(inputArray[rightrb-1])){
							floor++;
							leftrb++;
							last = -1;
						}else
							leftrb++;
					}
				}
			}
			System.out.println(floor);
		}

	}

}
