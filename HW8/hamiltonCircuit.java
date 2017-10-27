package hw8;

import java.util.ArrayList;
import java.util.Scanner;

public class hamiltonCircuit {
	public static boolean found = false;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int numberToTest =  scan.nextInt();
		for(int i=0; i<numberToTest; i++){
			found = false;
			int numberOfEdge = scan.nextInt();
			int[][] temp = new int[numberOfEdge][2];
			ArrayList<Integer> vertices = new ArrayList<Integer>();
			for(int j=0; j<numberOfEdge; j++){
				String line = scan.next().replaceAll("[()]","");
				//System.out.println(line);
				for(int k=0; k<2; k++){
					temp[j][k] = Integer.parseInt(line.split(",")[k]);
					if(!vertices.contains(temp[j][k])){
						vertices.add(temp[j][k]);
					}
				}
			}
			int G[][] = new int[vertices.size()+1][vertices.size()+1];
			int x[] = new int[vertices.size()+1];
			
			for(int k=0; k<numberOfEdge; k++){
				int a = temp[k][0];
				int b = temp[k][1];
//				System.out.println(a + " " + b);
				G[a][b] = G[b][a] = 1;
			}
			for(int j=1; j<vertices.size()+1; j++){
				x[j]=0;
			}
			x[1] = 1;
			Hamiltonian(2, G, x, vertices.size());
			
			if (found == false){
				System.out.println("False");
			}else{
				System.out.println("True");
			}
			
//			for(int j=1; j<vertices.size()+1; j++){
//				for(int k=1; k<vertices.size()+1; k++){
//					System.out.print(G[j][k]+ " ");
//				}
//				System.out.println();
//			}
			
			
		}

		
	}
	
	static void Hamiltonian(int k, int G[][], int x[], int n) {
		while (true) {
			NextValue(k, G, x, n);
			if (x[k] == 0)
				return;
			if (k == n) {
//				for (int i = 1; i <= k; i++)
//					System.out.print(x[i] + " ");
//				System.out.println();
				found = true;
				return;
			} else
				Hamiltonian(k + 1, G, x, n);
		}
	}
	static void NextValue(int k, int G[][], int x[], int n) {
		while (true) {
			x[k] = (x[k] + 1) % (n + 1);
			if (x[k] == 0)
				return;
			if (G[x[k - 1]][x[k]] != 0) {
				int j;
				for (j = 1; j < k; j++)
					if (x[k] == x[j])
						break;
				if (j == k)
					if ((k < n) || ((k == n) && G[x[n]][x[1]] != 0))
						return;
			}
		}
	}

}
