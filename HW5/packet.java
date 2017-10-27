package HW5;

import java.util.Scanner;


public class packet {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int[] input = new int[6];
		int numOfZero = 0;
		for(int i =0; i < 6; i++){
			input[i] = scan.nextInt();
			if(input[i]==0){
				numOfZero++;
			}
		}
		//System.out.println();
		while(true){
			if(numOfZero==6){
				break;
			}
			int total = 0;
			for(int i=input.length-1; i>=0; i--){
				if(i==5){
					total += input[i];
				}else if(i == 4){
					total += input[i];
					if(input[0]<91*input[i]){
						input[0] = 0;
					}else{
						input[0]-=91*input[i];
					}
				}else if(i==3){
					total += input[i];
					if(input[1]<(152*input[i])/8){
						input[1]=0;
						int res = 152*input[i]/8 - input[1];
						if(input[0]<res*8){
							input[0] = 0;
						}else{
							input[0]-=res*8;
						}
					}else{
						input[1]-=152*input[i]/8;
					}
				}else if(i==2){
					if(input[i]%4==0){
						total += input[i]/4;
					}else {
						total += input[i]/4+1;
						int res = input[i]%4*27;
						if(input[1]!=0 && input[1]*8<res){
							input[1]=0;
							res -= input[1]*8;
							if(input[0]!=0 && input[0]<res){
								input[0]=0;
							}else{
								input[0]-=res;
							}
						}else{
							input[1]-= res/8;
						}
					}
				}
			}
			System.out.println(total);
			numOfZero = 0;
			for(int i =0; i < 6; i++){
				input[i] = scan.nextInt();
				if(input[i]==0){
					numOfZero++;
				}
			}
		}
	}

}
