import java.util.Scanner;
public class fibonacci{
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		int numoftest = Integer.valueOf(scanner.nextLine());
		for(int i=0; i<numoftest; i++){
			System.out.println("number in seqeunce: ");
			int num_of_sequence = scanner.nextInt();
			System.out.println(fibonacci(num_of_sequence));
		}
	}
	public static int fibonacci(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		return  fibonacci(n-1) + fibonacci(n-2);
		
	}

}
