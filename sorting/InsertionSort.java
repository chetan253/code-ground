/*
	Author: Chetan Patil
	Insertion Sort
*/
import java.io.*;
class InsertionSort{
	
	static int[] sort(int[] a, int n){
		boolean sorted;
		for(int i = 1; i < n; i++){
			sorted = false;
			int j = i;
			while(!sorted && j > 0){
				if(a[j] < a[j-1]){
					sorted = false;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					j--;
					continue;
				}
				sorted = true;
			}
		}
		return a;
	}

	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter the numeber of elements to be sorted: ");
			int n = Integer.parseInt(br.readLine());
			System.out.println("Enter the"+ n +" elements to be sorted: ");
			int arr[]  = new int[n];
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			arr = sort(arr, n);
			System.out.println("Sorted are: ");
			for(int i = 0; i < n; i++){
				System.out.println(arr[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
