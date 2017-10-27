package hw9;

import java.util.Scanner;

public class addThePage {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int inputNum = scan.nextInt();
		for(int i=0; i<inputNum; i++){
			int page = scan.nextInt();
			int totalPage =(int)Math.sqrt(page*2);
			//System.out.println(totalPage);
			if( (totalPage*(totalPage+1)/2) <= page ){
				totalPage+=1;
			}
			int leftpage = (totalPage*(totalPage+1)/2) - page;
			System.out.println(leftpage + " " + totalPage);
		}

	}

}
