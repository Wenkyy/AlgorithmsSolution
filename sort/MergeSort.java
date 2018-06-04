/**
 * Merge Sort 
 * Given an array of integers, 
 * sort the elements in the array in ascending order. 
 * The Merge sort algorithm should be used to solve this problem.
 **/
public class MergeSort{
	public int[] sort(int[] array){
		//corner cases
		if(array == null || array.length == 0){
			return array;
		}
		int[] helper = new int[array.length];
		divideArray(array,helper,0,array.length - 1);
		return array;

	}
	public void divideArray(int[] arr, int[] helper, int head, int tail){
		if(head == tail){
			return;
		}
		int mid = head + (tail - head) / 2;
		divideArray(arr, helper, head, mid);
		divideArray(arr, helper, mid + 1, tail);
		merge(arr, helper, head, tail, mid);
	}
	public void merge(int[] arr, int[] helper, int head, int tail, int mid){
		// should include element on tail !!
		for(int i = head; i <= tail ; i++){
			helper[i] = arr[i];
		}
		int firstArrayStartIndex = head;
		int secondArrayStartIndex = mid + 1;
		while(firstArrayStartIndex <= mid && secondArrayStartIndex<= tail){
			if(helper[firstArrayStartIndex] < helper[secondArrayStartIndex]){
				arr[head++] = helper[firstArrayStartIndex++];
			}else{
				arr[head++] = helper[secondArrayStartIndex++];
			}
		}
		while(firstArrayStartIndex <= mid){
			arr[head++] = helper[firstArrayStartIndex++];
		}
		//if secondArrayStartIndex <= tail no need to copy, because they've already in ringt place;
	}
}

// time complexity O(nlogn)
//  3 4 5 7 0 6 1 2   O(1)
//       /     \
// 3 4 5 7  0 6 1 2  O(1)*2 
//   /\         /\
// 34  57    06  12   O(1)*4 
// /\  /\    /\  /\
//3 4 5 7  0  6 1  2   
// .......				O(1)*n   （a1 - anq)/(1-q) = O(n)
//\/  \/   \/   \/      O(n) // need loop both sub array 
//34  57   06   12   
//  \/       \/
// 3457     0126       O(n)
//     \   /
//   01234567         O(n)  // total is O(nlogn)
// space complexity O(n)
