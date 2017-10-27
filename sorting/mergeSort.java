package sorting;

public class mergeSort {
	private int[] numbers;
	private int[] extraHandler;
	private int length;
	private int[] temp;
	mergeSort(int[] inputArray){
		numbers = inputArray.clone();
		length = inputArray.length;
		extraHandler = new int[length];
		for(int i=0; i<numbers.length; i++){
			extraHandler[i] = numbers[i];
		}
	}
	public static void main(String[] args) {
		int[] input = {10,12,14,1,100,12,32};
		mergeSort mergeSort = new mergeSort(input);
		System.out.print("before: ");
		for(int ele: input ){
			System.out.print(ele +" ");
		}
		System.out.println();
		mergeSort.divide(0, input.length-1);
		System.out.println("\nafter: ");
		for(int ele:mergeSort.numbers){
			System.out.print(ele + " ");
		}
		
	}
	public void divide(int left, int right){
		if(left < right){
			int middle = (left + right)/2;
			divide(left,middle);
			divide(middle+1, right);
			merge(left, middle, right);
			extraHandler = numbers.clone();
			System.out.println(left+ " " + middle +" " +right);
			printArray();
			System.out.println();
		}
	}
	public void printArray(){
		System.out.println("array: ");
		for(int ele: numbers){
			System.out.print(ele+" ");
			
		}
	}
	public void merge(int l, int m, int r){
		int left = l;
		int right = m+1;
		int out = l;
		
		//System.out.println("here");
		while(left <= m || right <= r){
			if(left > m){
				numbers[out] = extraHandler[right];
				right++;
				out++;
				
			}else if(right > r){
				numbers[out] = extraHandler[left];
				left++;
				out++;
			}else{
				if(extraHandler[left] > extraHandler[right]){
					numbers[out] = extraHandler[right];
					//System.out.println("out: " + out);
					right++;
				}else if(numbers[left] <= numbers[right]){
					numbers[out] = extraHandler[left];
					left++;
				}
				out++;
			}
			
		}
	}
	

}
