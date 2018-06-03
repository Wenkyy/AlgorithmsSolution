/**
 * Selection Sort 
 * Given an array of integers, 
 * sort the elements in the array in ascending order. 
 * The selection sort algorithm should be used to solve this problem.
 **/

public class SelectionSort{
	public int[] Sort(int[] input){
		// corner case
		if(input == null || input.length == 0){
			return input;
		}
		int length = input.length;
		int global_min_index;
		for(int i = 0; i < length - 1; i++){
			global_min_index = i;
			for(int j = i + 1; j < length; j++){
				if(input[j] < input[global_min_index]){
					global_min_index = j;
				}
			}
			// swap the smallest element with the ith of the array
			swap(input,global_min_index,i);
		}
		return input;
	}
	private void swap(int[] input, int min, int i){
		int temp = input[min];
		input[min] = input[i];
		input[i] = temp;
	}

}

// time complexity O(n^2)
// space complexity O(1)


