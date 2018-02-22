import java.io.*;
class MergeSort{
	static void mergesort(int[] arr, int[] temp, int leftStart, int rightEnd){
		if(rightEnd > leftStart){
			int mid = (leftStart + rightEnd) / 2;
			mergesort(arr, temp, leftStart, mid);
			mergesort(arr, temp, mid + 1, rightEnd);
			merge(arr, temp, leftStart, rightEnd);
		}
	}
	
	static void merge(int[] arr, int[] temp, int leftStart, int rightEnd){
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightS = leftEnd + 1;
		int tempIndex = leftStart;
		int leftS = leftStart;

		while(leftS <= leftEnd && rightS <= rightEnd){
			if(arr[leftS] <= arr[rightS]){
				temp[tempIndex] = arr[leftS];
				leftS++;
			}
			else{
				temp[tempIndex] = arr[rightS];
				rightS++;
			}
			tempIndex++;
		}
		System.arraycopy(arr, leftS, temp, tempIndex, leftEnd - leftS + 1);
		System.arraycopy(arr, rightS, temp, tempIndex, rightEnd - rightS + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
	}
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter the number of elements to be sorted");
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			System.out.println("Enter " + n + " elements");
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			mergesort(arr, new int[arr.length], 0, arr.length-1);
			for(int i : arr){
				System.out.print(i + " ");
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
