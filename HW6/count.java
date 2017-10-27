package HW6;

import java.util.Scanner;

public class count {

	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numberOfTest = scan.nextInt();
		for(int i=0; i<numberOfTest; i++){
			int squareSize = scan.nextInt();
			int searchNum = scan.nextInt();
			
			int x = 0;
			int y =0;
			if( searchNum <= ((1+squareSize)*squareSize/2)){
				int numbers = 1;
				int level = 1;
				while(searchNum > numbers){
					level++;
					numbers = numbers + level;
				}
				boolean even = false;
				if(level%2==0){ // even
					x = level;
					y = 1;
					even = true;
				}else{
					x = 1;
					y = level;
				}
				
				int left = searchNum - ((1+(level-1))*(level-1)/2) - 1;
				int k =0;
				while(k<left){
					if(even == true){
						x--;
						y++;
					}else{
						x++;
						y--;
					}
					k++;
				}
//				System.out.println(x + " , " + y);
				System.out.println(min(x,y));
			}else{
				searchNum -= ((1+squareSize)*squareSize/2);
				int numbers = squareSize-1;
				int level = squareSize+1;
				while(searchNum > numbers){
					searchNum -= numbers;
					numbers--;
					level++;
				}
				boolean even = false;
				if(level%2==0){ // even
					x = squareSize;
					y = level+1-squareSize;
					even = true;
				}else{
					x = level+1-squareSize;
					y = squareSize;
				}
//				System.out.println(x + " , " +y);
				int k = searchNum - 1;
				while(k >0){
					if(even){
						x--;
						y++;
					}else{
						x++;
						y--;
					}
					k--;
				}
				//System.out.println(x + " , "+ y);
				System.out.println(min(squareSize+1-x, squareSize+1-y));
			}
		}

	}
	public static int min(int a, int b){
		if(a >= b){
			return b;
		}
		return a; 
	}

}
