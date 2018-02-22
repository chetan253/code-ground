import java.io.*;
class SelectionSort{
	static int linearSearchMin(int[] arr, int j, int n){
		int min = Integer.MAX_VALUE;
		int pos = 0; 
		for(int i = j; i < n; i++){
			if(arr[i] < min){
				min = arr[i];
				pos = i;
			}
		}
		return pos;
	}
	static void sort(int[] arr, int n){
		for(int i = 0; i < n-1; i++){
			int pos = linearSearchMin(arr,i, n);
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
		System.out.println("Sorted array is: ");
		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter the number of elements to be sorted: ");
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			System.out.println("Enter the "+n+" elements to be sorted: ");
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			sort(arr, n);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
