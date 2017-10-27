package algHW;

import java.util.Scanner;


public class NumberSort_2 {
	private String s = "";
	private int index = -1;
	private int value = -1;
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int roundsToTest = scan.nextInt();
		for (int i = 0; i < roundsToTest; i++) {
			System.out.println();
			int length = scan.nextInt();
			int number = scan.nextInt();
			NumberSort_2[] nodeArr = new NumberSort_2[number];
			for (int n = 0; n < number; n++) {
				char[] input = new char[length];
				String inputStr = scan.next();
				for (int j = 0; j < length; j++)
					input[j] = inputStr.charAt(j);
				int value = 0;
				for (int k = 0; k < length - 1; k++) {
					for (int l = k + 1; l < length; l++){
						if ((input[k]-input[l])>0){
							value++;
							//System.out.println(input[k]+ " " + input[l]+" : "+value);
						}
					}

				}
				NumberSort_2 node = new NumberSort_2();
				node.index = n;
				node.s = inputStr;
				node.value = value;
				
				nodeArr[n] = node;
			}
			for(int h = nodeArr.length-1; h>0; h--){
				for(int g = 0; g<h; g++){
					if(nodeArr[g].value < nodeArr[g+1].value){
						NumberSort_2 temp = nodeArr[g];
						nodeArr[g] = nodeArr[g+1];
						nodeArr[g+1] = temp;

					}else if(nodeArr[g].value == nodeArr[g+1].value){
						if(nodeArr[g].index < nodeArr[g+1].index){
							NumberSort_2 temp = nodeArr[g];
							nodeArr[g] = nodeArr[g+1];
							nodeArr[g+1] = temp;
						}
					}
				}
				System.out.println(nodeArr[h].s);
			}
			System.out.println(nodeArr[0].s);
			
		}

	}

}
