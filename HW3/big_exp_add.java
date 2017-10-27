package algHW;


import java.math.BigInteger;
import java.util.Scanner;

public class big_exp_add {
	public static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int numberToTest = scan.nextInt();
		big_exp_add Badd = new big_exp_add();
		for(int i=0; i<numberToTest; i++){
			int m = scan.nextInt();
			int n = scan.nextInt();
			System.out.println(Badd.getExp(m).add(Badd.getExp(n)));
		}
		

	}
	public BigInteger getExp(int num){
		BigInteger output = BigInteger.valueOf(0);
		if(num == 2)
			return output.valueOf(4);
		else if(num==3)
			return output.valueOf(8);
		
		if(num%2==0){
			return getExp(num/2).multiply(getExp(num/2));
		}else {
			return getExp(num/2).multiply(getExp(num/2+1));
		}
	}

}
