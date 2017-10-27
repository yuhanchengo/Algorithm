package sorting;

import java.util.Random;

public class quickSort {

	public static void main(String[] args) {
		Random rand = new Random();
		quickSort s = new quickSort();
		int[] input = new int[20];
		for(int i=0; i<20; i++){
			input[i] = rand.nextInt(40);
		}
		for(int ele: input){
			System.out.print(ele+" ");
		}
		System.out.println();
		s.QuickSort(input, 0, input.length-1);
//		for(int ele: input){
//			System.out.print(ele+" ");
//		}
	}

	public void QuickSort(int[] A, int lb, int rb) {
		int pivot = A[rb];
		int l = lb;
		int r = rb;
		if (lb >= rb) {
			return;
		}
		while (true) {
			//System.out.println("l: "+l + "r: "+r);
			while(A[l] < pivot) {
				l++;
				//System.out.println("here" + l);
			}
			//System.out.println("A[l]: " + A[l]);
			while(A[r] > pivot) {
				//System.out.println("here2");
				r--;
			}
			if (l<r) {
				int temp = A[r];
				A[r] = A[l];
				A[l] = temp;
				l++;
				r--;
			}else{
				break;
			}
			
		}
		int temp = pivot;
		pivot = A[l];
		A[l] = temp;
		
		QuickSort(A,lb,l-1);
		QuickSort(A,l+1,rb);
		for(int ele: A){
			System.out.print(ele+" ");
		}
		System.out.println();

	}

}
