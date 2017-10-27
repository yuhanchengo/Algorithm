package HW6;


import java.util.Scanner;

public class LCSS {

	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numberOfInput = scan.nextInt();
		
		for(int i =0; i < numberOfInput; i++){
			String X = scan.next();
			String Y = scan.next();
			int[][] c = new int[X.length()+1][Y.length()+1];
			int[][] b = new int[X.length()+1][Y.length()+1];
			
			for(int j=0; j< Y.length()+1; j++ ){
				c[0][j] = 0;
			}
			for(int r=0; r<X.length()+1; r++){
				c[r][0] = 0;
			}
			for(int k = 1; k < X.length()+1; k++){
				for(int l = 1; l < Y.length()+1; l++){
					if(X.charAt(k-1) == Y.charAt(l-1)){
						c[k][l] = c[k-1][l-1] + 1;
						b[k][l] = 2; // 2 代表箭頭指向斜上
					}else{
						if(c[k][l-1] >= c[k-1][l]){
							c[k][l] = c[k][l-1];
							b[k][l] = 1; // 1代表箭頭指向左
						}else{
							c[k][l] = c[k-1][l];
							b[k][l] = 0; // 0 代表箭頭指向上
						}
					}
				}
			}
			
			
			// print c and b
//			System.out.println("-------c-------");
//			for(int a = 0; a < X.length()+1; a++){
//				for(int j = 0; j<Y.length()+1; j++){
//					System.out.print(c[a][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("--------b-------");
//			for(int a = 0; a<X.length()+1; a++){
//				for(int j = 0; j<Y.length()+1; j++){
//					System.out.print(b[a][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(c[X.length()][Y.length()]);
			
		}
		
	}

}
