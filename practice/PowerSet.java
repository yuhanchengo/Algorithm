package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PowerSet {
	//public static Scanner scan;

	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\joy\\Desktop\\123.txt"));
			int number = Integer.valueOf(br.readLine());
			System.out.println(number);
			int[][] array = new int[number][number];
			
			while(br.ready()){
				for(int i =0; i<number; i++){
					for(int j =0; j<number; j++){
						array[i][j] = Integer.valueOf(br.readLine());
					}
				}
			}
			br.close();
			for(int i=0; i<number; i++){
				for(int j=0; j<number; j++){
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public int returnColSum(){
		int ans=1;
		int a =0;
		if(a==0){
			return ans; 
		}else{
			return -1;
		}
	}


}
