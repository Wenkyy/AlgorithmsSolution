/**
 * Quick Sort 
 * Given an array of integers, 
 * sort the elements in the array in ascending order. 
 * The Quick sort algorithm should be used to solve this problem.
 **/
public class QuickSort{
	public int[] Sort(int[] array){
		//corner case
		if(array == null && array.length == 0){
			return array;
		}
		quickSort(array,0,array.length-1);
		return array;

	}

	public void quickSort(int[] arr, int head, int tail){
		if(head >= tail){
			return;
		}
		
		int pivotIndex = partition(arr,head, tail);
		
		quickSort(arr,head,pivotIndex-1);
		quickSort(arr,pivotIndex+1,tail);

	}
	public int partition(int[] arr, int head, int tail){
		int pivotIndex = tail;
		int pivotValue = arr[pivotIndex];
		int endOfScannedArray = tail - 1;
		int startOfScannedArray = head;

		while(startOfScannedArray <= endOfScannedArray){
			// if(arr[startOfScannedArray] > pivotValue){
			// 	swap(arr,startOfScannedArray,endOfScannedArray--);
			// }else{
			// 	startOfScannedArray++;
			// }
			if(arr[startOfScannedArray] < pivotValue){
				startOfScannedArray ++;
			}else if(arr[endOfScannedArray] > pivotValue){
				endOfScannedArray --;
			}else{
				swap(arr,startOfScannedArray++,endOfScannedArray--);
			}
		}
		swap(arr,startOfScannedArray,pivotIndex);
		return startOfScannedArray;
	}
	public void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}