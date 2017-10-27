package sorting;

import java.util.Random;

public class insertionSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] A = new int[20];
		for (int i = 0; i < 20; i++) {
			A[i] = rand.nextInt(100);
		}
		System.out.println("Before sorting");
		for (int ele : A) {
			System.out.print(ele + " ");
		}
		System.out.println("\nAfter sorting");
		insertionSort a = new insertionSort();
		a.Sort(A, A.length);
		for (int ele : A) {
			System.out.print(ele + " ");
		}

	}

	public void Sort(int[] A, int n) {
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int input = A[i];
			while (j >= 0 && input<A[j]) {
				A[j + 1] = A[j];
				j--;
				if(j<0)
					break;
			}
			A[j + 1] = input;
		}
	}

}
