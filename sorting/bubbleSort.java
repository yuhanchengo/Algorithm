package sorting;

import java.util.Random;

public class bubbleSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] A = new int[20];
		for(int i =0; i<20; i++){
			A[i] = rand.nextInt(100);
		}
		bubbleSort s = new bubbleSort();
		System.out.println("before Sorting: ");
		for(int ele:A){
			System.out.print(ele + " ");
		}
		System.out.println("\nAfter Sorting");
		s.sort(A,A.length);
		for(int ele:A){
			System.out.print(ele + " ");
		}
	}
	public void sort(int[] A, int n){
		for(int i = n-1; i>0; i--){
			for( int j = 0; j<i; j++){
//				System.out.println(j);
				if(A[j]>A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}			
			}
		}
	}

}
