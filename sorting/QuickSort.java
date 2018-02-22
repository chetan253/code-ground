import java.io.*;
class QuickSort{
	
	static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	static void quickSort(int[] arr, int left, int right){
		if(left >= right){
			return;
		}
		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}
	
	static int partition(int[] arr, int left, int right, int pivot){
		while(left <= right){
			while(arr[left] < pivot){
				left++;
			}
			while(arr[right] > pivot){
				right--;
			}
			if(left <= right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{13,12,5,4,8,9,1,3,6,4};
		quickSort(arr);
		for(int i : arr){
			System.out.println(i);
		}
	}
}
