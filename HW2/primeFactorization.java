import java.util.Scanner;

public class primeFactorization{
	public static Scanner scanner;
	public static void main(String[] args){
		scanner = new Scanner(System.in);
		int inputNum = Integer.valueOf(scanner.nextLine());
		System.out.println(factorization(inputNum));	
	}
	public static String factorization(int input){
		int power = 0; // calculate the number of power
		boolean first=true;	
		String returnString = "";
		int input_copy = input;
		for(int i=2; i<=input; i++){
			if(checkPrime(i) && input_copy%i==0){
				while(input_copy%i==0){
					power++;
					input_copy/=i;
				}
				if(!first){
					returnString += '*';
				}else
					first = false;
				if(power>1){
					returnString += String.valueOf(i)+'^'+String.valueOf(power);
				}else
					returnString += String.valueOf(i);
				//System.out.println(returnString);
				power = 0;
			}
			
		}
		return returnString;
	}
	public static boolean checkPrime(int num){
		for(int i=2; i<=Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}

}
